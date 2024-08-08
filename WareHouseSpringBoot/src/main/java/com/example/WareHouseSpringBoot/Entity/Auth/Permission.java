package com.example.WareHouseSpringBoot.Entity.Auth;

import com.example.WareHouseSpringBoot.Entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Permission")
public class Permission {
    @Id
    String name;
    String description;
}
