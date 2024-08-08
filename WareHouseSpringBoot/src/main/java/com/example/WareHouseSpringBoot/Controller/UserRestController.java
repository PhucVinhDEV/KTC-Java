package com.example.WareHouseSpringBoot.Controller;

import com.example.WareHouseSpringBoot.DTO.ApiResponse;
import com.example.WareHouseSpringBoot.DTO.Mapper.UserMapper;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.AuthenticationRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.UserCreateRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.AuthenticationResponese;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.UserReponeseDTO;
import com.example.WareHouseSpringBoot.Entity.Auth.User;
import com.example.WareHouseSpringBoot.Exception.AppException;
import com.example.WareHouseSpringBoot.Exception.ErrorCode;
import com.example.WareHouseSpringBoot.Service.AuthenticationService;
import com.example.WareHouseSpringBoot.Service.AuthService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    AuthenticationService authenticationService;



    @PostMapping("/Register")
    public ApiResponse<AuthenticationResponese> register(@RequestBody UserCreateRequest request) {
        if (userService.existsByUsername(request.getUsername())) {
            throw  new AppException(ErrorCode.UserExitsted);
        }
        User user = userService.save(userMapper.UserCreateconvertToEntity(request));
        return ApiResponse.<AuthenticationResponese>builder()
                .result( authenticationService.authenticate(AuthenticationRequest.builder()
                        .username(request.getUsername())
                        .password(request.getPassword())
                        .build()))
                .status(201)
                .message("User registered successfully")
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserReponeseDTO>> getAllUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("User name: {}", authentication.getName());
        authentication.getAuthorities().forEach(g -> log.info("GrantedAuthority: {}", g));
        return ApiResponse.<List<UserReponeseDTO>>builder()
                .status(200)
                .message("All users")
                .result(userService.GetAllUser())
                .build();
    }


}
