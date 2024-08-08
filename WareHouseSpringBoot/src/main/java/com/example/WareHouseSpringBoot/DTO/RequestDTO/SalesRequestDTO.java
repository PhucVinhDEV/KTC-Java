package com.example.WareHouseSpringBoot.DTO.RequestDTO;

import com.example.WareHouseSpringBoot.Entity.Book.Books;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalesRequestDTO {
    int Quantity;
    String note;
    long bookId;
}
