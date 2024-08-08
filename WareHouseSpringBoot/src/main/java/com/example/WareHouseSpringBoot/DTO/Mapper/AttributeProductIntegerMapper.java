package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.AtrributeIntegerRequestDTO;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductInteger;
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
public class AttributeProductIntegerMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    ProductRepository productRepository;

    public AttributeProductInteger toAttributeProductInteger(AtrributeIntegerRequestDTO requestDTO) {
        AttributeProductInteger attributeProductInteger = modelMapper.map(requestDTO, AttributeProductInteger.class);
        attributeProductInteger.setAttribute(attributeRepository.findById(requestDTO.getAttributeName())
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION)));
        attributeProductInteger.setProduct(productRepository.findById(requestDTO.getProductId())
                .orElseThrow(()->new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION)));
        return attributeProductInteger;
    }

    public AtrributeIntegerRequestDTO convertToDTO(AttributeProductInteger attributeProductInteger) {
        AtrributeIntegerRequestDTO requestDTO = modelMapper.map(attributeProductInteger, AtrributeIntegerRequestDTO.class);
        requestDTO.setProductId(attributeProductInteger.getProduct().getId());
        requestDTO.setAttributeName(attributeProductInteger.getAttribute().getAttributeName());
        return requestDTO;
    }
}
