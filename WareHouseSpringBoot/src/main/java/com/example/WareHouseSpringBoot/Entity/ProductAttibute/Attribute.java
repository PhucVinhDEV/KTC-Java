package com.example.WareHouseSpringBoot.Entity.ProductAttibute;

import com.example.WareHouseSpringBoot.Entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Attribute extends BaseEntity<String> {

    @Id
    String attributeName;

    String attributeDescription;
}
