package com.example.WareHouseSpringBoot.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtrributeDateRequestDTO {
    String attributeName;
    Long productId;
    LocalDate attributeValue;
    String note;
}
