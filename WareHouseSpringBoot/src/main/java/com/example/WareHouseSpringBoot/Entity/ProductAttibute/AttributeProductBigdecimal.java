package com.example.WareHouseSpringBoot.Entity.ProductAttibute;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttributeProductBigdecimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @ManyToOne
    @JoinColumn(name = "attribute_name")
     Attribute attribute;

    @ManyToOne
    @JoinColumn(name = "product_id")
     Product product;

     BigDecimal attributeValue;
     String note;
}
