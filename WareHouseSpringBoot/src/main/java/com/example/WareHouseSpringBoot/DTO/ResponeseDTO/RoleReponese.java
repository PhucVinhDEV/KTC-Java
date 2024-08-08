package com.example.WareHouseSpringBoot.DTO.ResponeseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleReponese {
    String name;
    String description;
    Set<PermissionReponese> permissions;
}

