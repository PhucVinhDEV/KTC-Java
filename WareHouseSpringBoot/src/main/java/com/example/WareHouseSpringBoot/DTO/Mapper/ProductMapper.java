package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.*;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.Product;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.WareHouse;
import com.example.WareHouseSpringBoot.Exception.AppException;
import com.example.WareHouseSpringBoot.Exception.ErrorCode;
import com.example.WareHouseSpringBoot.Repository.WareHouseRepository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    @Autowired
    ModelMapper modelMapper;

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
    AttributeProductIntegerMapper attributeProductIntegerMapper;

    @Autowired
    AttributeProductStringRepository attributeProductStringRepository;

    @Autowired
    AttributeProductStringMapper attributeProductStringMapper;

    @Autowired
    AttributeProductDateMapper attributeProductDateMapper;

    @Autowired
    AttributeProductBigdecimalMapper attributeProductBigdecimalMapper;

    public Product convertToEntity(ProductRequestDTO requestDTO){
        Product product = modelMapper.map(requestDTO, Product.class);
        WareHouse wareHouse = wareHouseRepository.findById(requestDTO.getWarehouseId()).orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
        product.setWarehouse(wareHouse);
        return product;
    }

    public ProductRequestDTO convertToDTO(Product product){
        ProductRequestDTO productRequestDTO = modelMapper.map(product, ProductRequestDTO.class);
        productRequestDTO.setWarehouseId(product.getWarehouse().getId());
        productRequestDTO.setBigdecimalAttributes(atrributeBigdecimalRequestDTOList(product));
        productRequestDTO.setDateAttributes(atrributeDateRequestDTOList(product));
        productRequestDTO.setStringAttributes(atrributeStringRequestDTOList(product));
        productRequestDTO.setIntAttributes(atrributeIntegerRequestDTOList(product));
        return productRequestDTO;
    }

    protected List<AtrributeIntegerRequestDTO> atrributeIntegerRequestDTOList(Product product){
        return attributeProductIntegerRepository.findAllByProduct(product)
                .stream().map(attributeProductIntegerMapper::convertToDTO).toList();
    }

    protected List<AtrributeStringRequestDTO> atrributeStringRequestDTOList(Product product){
        return attributeProductStringRepository.findAllByProduct(product)
                .stream().map(attributeProductStringMapper::convertToDTO).toList();
    }

    protected List<AtrributeDateRequestDTO> atrributeDateRequestDTOList(Product product){
        return attributeProductDateRepository.findAllByProduct(product)
                .stream().map(attributeProductDateMapper::convertToDTO).toList();
    }
    protected List<AtrributeBigdecimalRequestDTO> atrributeBigdecimalRequestDTOList(Product product){
        return attributeProductBigdecimalRepository.findAllByProduct(product)
                .stream().map(attributeProductBigdecimalMapper::convertToDTO).toList();
    }
}
