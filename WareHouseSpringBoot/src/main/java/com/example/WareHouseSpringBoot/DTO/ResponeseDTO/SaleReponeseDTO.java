package com.example.WareHouseSpringBoot.DTO.ResponeseDTO;

import com.example.WareHouseSpringBoot.DTO.BaseDTO;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleReponeseDTO extends BaseDTO<String> {
    Long SaleId;
    int Quantity;
    String note;
    BookReponesesDTO bookReponesesDTO;
    BigDecimal totalPrice;
}
