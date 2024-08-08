package com.example.WareHouseSpringBoot.Service.WareHouseService.Implement;

import com.example.WareHouseSpringBoot.DTO.Mapper.ProductMapper;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.*;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.*;
import com.example.WareHouseSpringBoot.Repository.WareHouseRepository.*;
import com.example.WareHouseSpringBoot.Service.WareHouseService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    AttributeProductIntegerRepository attributeProductIntegerRepository;

    @Autowired
    AttributeProductStringRepository atributeProductStringRepository;

    @Autowired
    AttributeProductDateRepository attributeProductDateRepository;

    @Autowired
    AttributeProductBigdecimalRepository attributeProductBigdecimalRepository;

    @Autowired
    AttributeRepository attributeRepository;

    @Override
    public Product createProductFromDTO(ProductRequestDTO productRequestDTO) {
        WareHouse warehouse = wareHouseRepository.findById(productRequestDTO.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        Product product = Product.builder()
                .name(productRequestDTO.getName())
                .price(productRequestDTO.getPrice())
                .description(productRequestDTO.getDescription())
                .warehouse(warehouse)
                .build();
        product = productRepository.save(product);

        // Lưu các thuộc tính số nguyên
        if (productRequestDTO.getIntAttributes() != null) {
            for (AtrributeIntegerRequestDTO intAttrDTO : productRequestDTO.getIntAttributes()) {
                Attribute attribute = attributeRepository.findById(intAttrDTO.getAttributeName())
                        .orElseThrow(() -> new RuntimeException("Attribute not found"));
                AttributeProductInteger attributeProductInt = AttributeProductInteger.builder()
                        .product(product)
                        .attribute(attribute)
                        .attributeValue(intAttrDTO.getAttributeValue())
                        .note(intAttrDTO.getNote())
                        .build();
                attributeProductIntegerRepository.save(attributeProductInt);
            }
        }

        // Lưu các thuộc tính ngày tháng
        if (productRequestDTO.getDateAttributes() != null) {
            for (AtrributeDateRequestDTO dateAttrDTO : productRequestDTO.getDateAttributes()) {
                Attribute attribute = attributeRepository.findById(dateAttrDTO.getAttributeName())
                        .orElseThrow(() -> new RuntimeException("Attribute not found"));
                AttributeProductDate attributeProductDate = AttributeProductDate.builder()
                        .product(product)
                        .attribute(attribute)
                        .attributeValue(dateAttrDTO.getAttributeValue()) // Chuyển đổi từ String sang Date nếu cần thiết
                        .note(dateAttrDTO.getNote())
                        .build();
                attributeProductDateRepository.save(attributeProductDate);
            }
        }

        // Lưu các thuộc tính BigDecimal
        if (productRequestDTO.getBigdecimalAttributes() != null) {
            for (AtrributeBigdecimalRequestDTO bigdecimalAttrDTO : productRequestDTO.getBigdecimalAttributes()) {
                Attribute attribute = attributeRepository.findById(bigdecimalAttrDTO.getAttributeName())
                        .orElseThrow(() -> new RuntimeException("Attribute not found"));
                AttributeProductBigdecimal attributeProductBigdecimal = AttributeProductBigdecimal.builder()
                        .product(product)
                        .attribute(attribute)
                        .attributeValue(bigdecimalAttrDTO.getAttributeValue())
                        .note(bigdecimalAttrDTO.getNote())
                        .build();
                attributeProductBigdecimalRepository.save(attributeProductBigdecimal);
            }
        }

        // Lưu các thuộc tính chuỗi
        if (productRequestDTO.getStringAttributes() != null) {
            for (AtrributeStringRequestDTO stringAttrDTO : productRequestDTO.getStringAttributes()) {
                Attribute attribute = attributeRepository.findById(stringAttrDTO.getAttributeName())
                        .orElseThrow(() -> new RuntimeException("Attribute not found"));
                AttributeProductString attributeProductString = AttributeProductString.builder()
                        .product(product)
                        .attribute(attribute)
                        .attributeValue(stringAttrDTO.getAttributeValue())
                        .note(stringAttrDTO.getNote())
                        .build();
                atributeProductStringRepository.save(attributeProductString);
            }
        }

        return product;
    }

    @Override
    public List<ProductRequestDTO> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::convertToDTO).toList();
    }

    @Override
    public ProductRequestDTO getProductWithAttributes(Long productId) {
        return null;
    }

    @Override
    public AttributeProductInteger addIntAttributeToProduct(Long productId, Long attributeId, Integer value, String note) {
        return null;
    }

    @Override
    public AttributeProductDate addDateAttributeToProduct(Long productId, Long attributeId, String value, String note) {
        return null;
    }

    @Override
    public AttributeProductBigdecimal addBigdecimalAttributeToProduct(Long productId, Long attributeId, BigDecimal value, String note) {
        return null;
    }

    @Override
    public AttributeProductString addStringAttributeToProduct(Long productId, Long attributeId, String value, String note) {
        return null;
    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public Product save(Product entity) {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Iterator<Product> findAll() {
        return null;
    }
}
