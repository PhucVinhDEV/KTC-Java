package com.example.WareHouseSpringBoot.DTO.ResponeseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionReponese {
    String name;
    String description;
}