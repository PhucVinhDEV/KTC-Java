package com.example.WareHouseSpringBoot.Controller;

import com.example.WareHouseSpringBoot.DTO.MailInfo;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.AuthenticationRequest;
import com.example.WareHouseSpringBoot.DTO.ApiResponse;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.IntrospecRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.LogoutRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.RefeshRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.AuthenticationResponese;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.IntrospecResponsee;
import com.example.WareHouseSpringBoot.Entity.Auth.User;
import com.example.WareHouseSpringBoot.Exception.AppException;
import com.example.WareHouseSpringBoot.Exception.ErrorCode;
import com.example.WareHouseSpringBoot.Service.AuthService.UserService;
import com.example.WareHouseSpringBoot.Service.AuthenticationService;
import com.example.WareHouseSpringBoot.Service.MailerService;
import com.nimbusds.jose.JOSEException;
import jakarta.mail.MessagingException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level =  AccessLevel.PRIVATE , makeFinal = true)
@RequestMapping("/auth")
public class AuthenticateController {

    AuthenticationService authenticationService;

    UserService userService;

    MailerService mailerService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponese> Login(@RequestBody AuthenticationRequest request) {
        return ApiResponse.<AuthenticationResponese>builder()
                .result(authenticationService.authenticate(request))
                .build();
    }

    @PostMapping("/refesh")
    ApiResponse<AuthenticationResponese>  authenticate(@RequestBody RefeshRequest request) throws ParseException, JOSEException {
        AuthenticationResponese result = authenticationService.refeshToken(request);
        return  ApiResponse.<AuthenticationResponese>builder()
                .result(result)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void>  logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {

        authenticationService.logout(request);
        return  ApiResponse.<Void>builder()
                .message("Logout successful")
                .build();
    }
    @PostMapping("/instrospec")
    ApiResponse<IntrospecResponsee>  authenticate(@RequestBody IntrospecRequest request) throws ParseException, JOSEException {
        IntrospecResponsee result = authenticationService.Instropec(request);
        return  ApiResponse.<IntrospecResponsee>builder()
                .status(201)
                .result(result)
                .build();
    }

    @PostMapping(value = "/api/send-verify")
    public ApiResponse<Integer> sendverify(@RequestParam("Email") String Email) {
        Random random = new Random();
        int min = 100000;
        int max = 999999;
        int verificationCode = random.nextInt(max - min + 1) + min;
        User user = userService.findById(Email);
       if( userService.existsByUsername(Email)){
           MailInfo mailSend = new MailInfo();
           mailSend.setFrom("artdevk18@gmail.com");
           mailSend.setTo(Email);
           mailSend.setSubject("Verification Code for Password Change");
           mailSend.setBody(formatEmailBody(verificationCode,user));
           try {
               mailerService.send(mailSend);
               return ApiResponse.<Integer>builder()
                       .message("send Verifi Code Successfully")
                       .result(verificationCode)
                       .build();
           } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
           }
       }
       else{
           throw  new AppException(ErrorCode.UserExitsted);
       }

    }

    private String formatEmailBody(int verificationCode,User user) {
        return "<html>" +
                "<body>" +
                "<h2>Your Verification Code</h2>" +
                "<p>Dear "+user.getLastName()+",</p>" +
                "<p>Your verification code for password change is:</p>" +
                "<h3>" + verificationCode + "</h3>" +
                "<p>Please use this code to verify your email address.</p>" +
                "<br>" +
                "<p>Best regards,</p>" +
                "<p>WareHouse Company Name</p>" +
                "</body>" +
                "</html>";
    }
}
