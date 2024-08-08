package com.example.WareHouseSpringBoot.DTO.ResponeseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponese {
    String token;
    boolean authenticated;
}
