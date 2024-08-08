package com.example.WareHouseSpringBoot.DTO.RequestDTO;

import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductBigdecimal;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductDate;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductInteger;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductString;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDTO {
    Long id;
    String name;
    BigDecimal price;
    String description;
    Long warehouseId;
    List<AtrributeIntegerRequestDTO> intAttributes;
    List<AtrributeStringRequestDTO> stringAttributes;
    List<AtrributeDateRequestDTO> dateAttributes;
    List<AtrributeBigdecimalRequestDTO> bigdecimalAttributes;
}
