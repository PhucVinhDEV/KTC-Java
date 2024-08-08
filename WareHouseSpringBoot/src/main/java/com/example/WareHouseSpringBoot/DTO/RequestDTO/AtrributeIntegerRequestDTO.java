package com.example.WareHouseSpringBoot.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtrributeIntegerRequestDTO {
    String attributeName;
    Long productId;
    Integer attributeValue;
    String note;
}
