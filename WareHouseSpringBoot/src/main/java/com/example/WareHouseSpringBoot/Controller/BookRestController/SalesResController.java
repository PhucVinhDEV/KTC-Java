package com.example.WareHouseSpringBoot.Controller.BookRestController;

import com.example.WareHouseSpringBoot.DTO.ApiResponse;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.SalesRequestDTO;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.SaleReponeseDTO;
import com.example.WareHouseSpringBoot.Service.BooksService.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Sale")
public class SalesResController {
    @Autowired
    SalesService salesService;

    @PostMapping
    public ApiResponse<SaleReponeseDTO> sale(@RequestBody SalesRequestDTO salesRequestDTO) {
        return ApiResponse.<SaleReponeseDTO>builder()
                .status(201)
                .message("Save sale Successful")
                .result(salesService.sale(salesRequestDTO))
                .build();
    }
}
