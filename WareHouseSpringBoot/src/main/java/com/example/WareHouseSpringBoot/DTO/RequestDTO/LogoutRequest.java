package com.example.WareHouseSpringBoot.DTO.RequestDTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogoutRequest {
    private String token;
}
