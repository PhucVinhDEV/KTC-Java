package com.example.WareHouseSpringBoot.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtrributeBigdecimalRequestDTO {
    String attributeName;
    Long productId;
    BigDecimal attributeValue;
    String note;
}
