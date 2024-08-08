package com.example.WareHouseSpringBoot.Controller.WareHouseRestController;

import com.example.WareHouseSpringBoot.DTO.ApiResponse;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.ProductRequestDTO;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.Product;
import com.example.WareHouseSpringBoot.Service.WareHouseService.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ApiResponse<Product> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        Product product = productService.createProductFromDTO(productRequestDTO);
        return ApiResponse.<Product>builder()
                .result(product)
                .message("Product created successfully")
                .status(201)
                .build();
    }

    @GetMapping
    public ApiResponse<List<ProductRequestDTO>> getAllProducts() {
        List<ProductRequestDTO> products = productService.getAllProducts();
        return ApiResponse.<List<ProductRequestDTO>>builder()
                .result(products)
                .message("Fetched all products")
                .status(201)
                .build();
    }
}
