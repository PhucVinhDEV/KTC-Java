package com.example.WareHouseSpringBoot.DTO.RequestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 6, max = 50, message = "USER_INVALID")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "PASSWORD_INVALID")
    private String password;

    private String firstName;
    private String lastName;


    @NotNull
    private LocalDate dob;
}
