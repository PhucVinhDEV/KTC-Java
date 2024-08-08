package com.example.WareHouseSpringBoot.DTO.ResponeseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IntrospecResponsee {
    boolean valid;
}
