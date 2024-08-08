package com.example.WareHouseSpringBoot.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtrributeStringRequestDTO {
    String attributeName;
    Long productId;
    String attributeValue;
    String note;
}
