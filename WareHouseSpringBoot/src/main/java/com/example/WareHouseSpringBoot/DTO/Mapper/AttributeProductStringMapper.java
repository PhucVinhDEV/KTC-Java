package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.AtrributeIntegerRequestDTO;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.AtrributeStringRequestDTO;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductInteger;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductString;
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
public class AttributeProductStringMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    ProductRepository productRepository;

    public AttributeProductString toAttributeProductString(AtrributeStringRequestDTO requestDTO) {
        AttributeProductString attributeProductInteger = modelMapper.map(requestDTO, AttributeProductString.class);
        attributeProductInteger.setAttribute(attributeRepository.findById(requestDTO.getAttributeName())
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION)));
        attributeProductInteger.setProduct(productRepository.findById(requestDTO.getProductId())
                .orElseThrow(()->new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION)));
        return attributeProductInteger;
    }

    public AtrributeStringRequestDTO convertToDTO(AttributeProductString attributeProductString) {
        AtrributeStringRequestDTO requestDTO = modelMapper.map(attributeProductString, AtrributeStringRequestDTO.class);
        requestDTO.setProductId(attributeProductString.getProduct().getId());
        requestDTO.setAttributeName(attributeProductString.getAttribute().getAttributeName());
        return requestDTO;
    }
}
