package com.example.WareHouseSpringBoot.Entity.ProductAttibute;

import com.example.WareHouseSpringBoot.Entity.BaseEntity;
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
public class Product extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    BigDecimal price;
    String description;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
     WareHouse warehouse;
}
