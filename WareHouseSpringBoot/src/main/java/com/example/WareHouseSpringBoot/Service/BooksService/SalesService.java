package com.example.WareHouseSpringBoot.Service.BooksService;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.SalesRequestDTO;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.SaleReponeseDTO;
import com.example.WareHouseSpringBoot.Entity.Book.Sales;
import com.example.WareHouseSpringBoot.Service.BaseService;

public interface SalesService extends BaseService<Sales, Long> {
    SaleReponeseDTO sale(SalesRequestDTO requestDTO);
}
