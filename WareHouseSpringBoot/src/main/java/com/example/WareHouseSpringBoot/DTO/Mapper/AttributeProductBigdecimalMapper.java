package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.AtrributeBigdecimalRequestDTO;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.AtrributeDateRequestDTO;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductBigdecimal;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductDate;
import com.example.WareHouseSpringBoot.Exception.AppException;
import com.example.WareHouseSpringBoot.Exception.ErrorCode;
import com.example.WareHouseSpringBoot.Repository.WareHouseRepository.AttributeRepository;
import com.example.WareHouseSpringBoot.Repository.WareHouseRepository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AttributeProductBigdecimalMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    ProductRepository productRepository;

    public AttributeProductBigdecimal toAttributeProductBigdecimal(AtrributeBigdecimalRequestDTO requestDTO) {
        AttributeProductBigdecimal attributeProductBigdecimal = modelMapper.map(requestDTO, AttributeProductBigdecimal.class);
        attributeProductBigdecimal.setAttribute(attributeRepository.findById(requestDTO.getAttributeName())
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION)));
        attributeProductBigdecimal.setProduct(productRepository.findById(requestDTO.getProductId())
                .orElseThrow(()->new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION)));
        return attributeProductBigdecimal;
    }

    public AtrributeBigdecimalRequestDTO convertToDTO(AttributeProductBigdecimal toAttributeProductBigdecimal) {
        AtrributeBigdecimalRequestDTO requestDTO = modelMapper.map(toAttributeProductBigdecimal, AtrributeBigdecimalRequestDTO.class);
        requestDTO.setProductId(toAttributeProductBigdecimal.getProduct().getId());
        requestDTO.setAttributeName(toAttributeProductBigdecimal.getAttribute().getAttributeName());
        return requestDTO;
    }
}
