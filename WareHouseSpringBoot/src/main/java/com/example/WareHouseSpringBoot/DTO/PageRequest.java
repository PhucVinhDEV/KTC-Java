package com.example.WareHouseSpringBoot.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageRequest {
    int page;
    String sortBy;
    String sortDirection;
}
