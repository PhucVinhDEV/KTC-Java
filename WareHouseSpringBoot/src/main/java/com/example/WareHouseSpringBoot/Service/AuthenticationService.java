package com.example.WareHouseSpringBoot.Service;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.AuthenticationRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.IntrospecRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.LogoutRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.RefeshRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.AuthenticationResponese;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.IntrospecResponsee;
import com.example.WareHouseSpringBoot.Entity.Auth.InvalidatedToken;
import com.example.WareHouseSpringBoot.Entity.Auth.User;
import com.example.WareHouseSpringBoot.Exception.AppException;
import com.example.WareHouseSpringBoot.Exception.ErrorCode;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.InvalidatedTokenRepository;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    InvalidatedTokenRepository invalidatedTokenRepository;

    @Value("${jwt.secretKey}")
    private String SignerKey;

    @NonFinal
    @Value("${jwt.valid-duration}")
    protected long VALID_DURATION;

    @NonFinal
    @Value("${jwt.refreshable-duration}")
    protected long REFRESHABLE_DURATION;

    public AuthenticationResponese authenticate(AuthenticationRequest authenticationRequest) {
            var user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(() -> new RuntimeException());
            log.info(authenticationRequest.getPassword());

        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
            log.info(passwordEncoder.encode(user.getPassword()));
            if (!authenticated) {
                throw new AppException(ErrorCode.USER_NOT_EXISTED);
            }

        String token = genarationToken(user);

            return  AuthenticationResponese.builder()
                    .authenticated(authenticated)
                    .token(token)
                    .build();
    }

    public  String genarationToken(User user) {

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issueTime(new Date())
                .issuer("BitzNomad")
                .expirationTime(new Date(
                        Instant.now().plus(3600, ChronoUnit.SECONDS).toEpochMilli()
                ))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope",buildScope(user))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SignerKey.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("JWT Exception", e);
            throw new RuntimeException(e);
        }
    }

    public void logout(LogoutRequest request) throws ParseException, JOSEException {
        try {
            SignedJWT signToken = VerifyToken(request.getToken(),false);

            String jit = signToken.getJWTClaimsSet().getJWTID();
            Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

            InvalidatedToken invalidatedToken =
                    InvalidatedToken.builder()
                            .id(jit)
                            .expiryTime(expiryTime)
                            .build();

            invalidatedTokenRepository.save(invalidatedToken);
        }catch (AppException exception){
            log.info("Token already expired");
        };
    }
    public AuthenticationResponese refeshToken(RefeshRequest request) throws ParseException, JOSEException {

        var SingJWT = VerifyToken(request.getToken(),true);

        var jit = SingJWT.getJWTClaimsSet().getJWTID();

        var expirationTime = SingJWT.getJWTClaimsSet().getExpirationTime();

        InvalidatedToken invalidatedToken = InvalidatedToken.builder()
                .id(jit)
                .expiryTime(expirationTime)
                .build();

        invalidatedTokenRepository.save(invalidatedToken);

        var u = SingJWT.getJWTClaimsSet().getSubject();

        var user = userRepository.findByUsername(u).orElseThrow(
                () -> new AppException(ErrorCode.UNAUTHORIZED)
        );


        String token = genarationToken(user);
        return  AuthenticationResponese.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    private SignedJWT VerifyToken(String token, boolean isRefesh) throws ParseException, JOSEException {
        //Tạo đối tượng JWSVerifier để xác mình bằng cách sử dụng SignerKey
        JWSVerifier verifier = new MACVerifier(SignerKey.getBytes());

        //Dùng token tạo ra SignedJWT
        SignedJWT signedJWT = SignedJWT.parse(token);

        //If isResh = true get ExpriTime to Refesh token
        //neu la refesh Expritime = GetissueTime +  REFRESHABLE_DURATION
        // neu ko phai resh expriTime = signedJWT.expritime
        Date expriTime = (isRefesh) ?
                new Date(signedJWT.getJWTClaimsSet().getIssueTime()
                        .toInstant().plus(REFRESHABLE_DURATION,ChronoUnit.SECONDS).toEpochMilli())
                : signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        //Kiểm tra xem token đã bị vô hiệu hóa chưa bằng cách tìm ID của token trong kho lưu trữ invalidatedTokenRepository.
        // Nếu token đã bị vô hiệu hóa, ném ra ngoại lệ AppException với mã lỗi UNAUTHENTICATED.
        if(!(verified && expriTime.after(new Date()))) throw  new AppException(ErrorCode.UNAUTHENTICATED);
        if(invalidatedTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID()))
            throw new AppException(ErrorCode.UNAUTHENTICATED);

        return signedJWT;
    }
    private String buildScope(User user) {
        StringJoiner stringJoiner = new StringJoiner(" ");

        if (!CollectionUtils.isEmpty(user.getRoles()))
            user.getRoles().forEach(role -> {
                stringJoiner.add("ROLE_" + role.getName());
                if (!CollectionUtils.isEmpty(role.getPermissions()))
                    role.getPermissions().forEach(permission -> stringJoiner.add(permission.getName()));
            });
        return stringJoiner.toString();
    }

    public IntrospecResponsee Instropec(IntrospecRequest request) throws JOSEException, ParseException {

        boolean isValid = true;

        try{
            VerifyToken(request.getToken(),false);
        }catch (AppException exception){
            isValid = false;
        }

        return IntrospecResponsee.builder()
                .valid(isValid)
                .build();
    }


}
