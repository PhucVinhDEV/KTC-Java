package com.example.WareHouseSpringBoot.Controller.WareHouseRestController;

import com.example.WareHouseSpringBoot.DTO.ApiResponse;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.Attribute;
import com.example.WareHouseSpringBoot.Service.WareHouseService.AttributeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/attribute")
@Slf4j
public class AttributeRestController {

    @Autowired
    AttributeService attributeService;

    @PostMapping
    public ApiResponse addAttribute(@RequestBody Attribute attribute) {
        return ApiResponse.builder()
                .result(attributeService.save(attribute))
                .message("Created attribute successfully")
                .build();
    }

    @GetMapping
    public ApiResponse<Iterator<Attribute>> getAttributes() {
        return ApiResponse.<Iterator<Attribute>>builder()
                .result(attributeService.findAll())
                .message("Get all attributes")
                .build();
    }
}
