package com.example.WareHouseSpringBoot.Entity.Book;

import com.example.WareHouseSpringBoot.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.awt.print.Book;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sales extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long SaleId;
    int Quantity;
    String note;

    @ManyToOne
    @JoinColumn(name = "book_BookId")
    Books book;
}
