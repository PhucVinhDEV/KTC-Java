package com.example.WareHouseSpringBoot.DTO.ResponeseDTO;

import com.example.WareHouseSpringBoot.DTO.BaseDTO;
import com.example.WareHouseSpringBoot.Entity.BaseEntity;
import com.example.WareHouseSpringBoot.Entity.Book.Sales;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookReponesesDTO extends BaseDTO<String> {
    Long BookId;
    String BookName;
    int Quantity;
    BigDecimal Price;
    boolean IsAvailable;
    int sellQuantity;
}
