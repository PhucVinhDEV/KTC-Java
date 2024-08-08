package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.AtrributeDateRequestDTO;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.AtrributeStringRequestDTO;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductDate;
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
public class AttributeProductDateMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    ProductRepository productRepository;

    public AttributeProductDate toAttributeProductDate(AtrributeDateRequestDTO requestDTO) {
        AttributeProductDate attributeProductDate = modelMapper.map(requestDTO, AttributeProductDate.class);
        attributeProductDate.setAttribute(attributeRepository.findById(requestDTO.getAttributeName())
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION)));
        attributeProductDate.setProduct(productRepository.findById(requestDTO.getProductId())
                .orElseThrow(()->new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION)));
        return attributeProductDate;
    }

    public AtrributeDateRequestDTO convertToDTO(AttributeProductDate attributeProductDate) {
        AtrributeDateRequestDTO requestDTO = modelMapper.map(attributeProductDate, AtrributeDateRequestDTO.class);
        requestDTO.setProductId(attributeProductDate.getProduct().getId());
        requestDTO.setAttributeName(attributeProductDate.getAttribute().getAttributeName());
        return requestDTO;
    }
}
