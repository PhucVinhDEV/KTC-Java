package com.example.WareHouseSpringBoot.DTO.ResponeseDTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
@Data
public class UserReponeseDTO {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    Set<RoleReponese> roles;
}
