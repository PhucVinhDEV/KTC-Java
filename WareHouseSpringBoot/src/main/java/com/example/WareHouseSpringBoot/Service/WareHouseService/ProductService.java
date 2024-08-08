package com.example.WareHouseSpringBoot.Service.WareHouseService;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.ProductRequestDTO;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.*;
import com.example.WareHouseSpringBoot.Service.BaseService;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService extends BaseService<Product,String> {
    Product createProductFromDTO(ProductRequestDTO productRequestDTO);

    List<ProductRequestDTO> getAllProducts();

    ProductRequestDTO getProductWithAttributes(Long productId);

    AttributeProductInteger addIntAttributeToProduct(Long productId, Long attributeId, Integer value, String note);

    AttributeProductDate addDateAttributeToProduct(Long productId, Long attributeId, String value, String note);

    AttributeProductBigdecimal addBigdecimalAttributeToProduct(Long productId, Long attributeId, BigDecimal value, String note);

    AttributeProductString addStringAttributeToProduct(Long productId, Long attributeId, String value, String note);
}
