package com.example.WareHouseSpringBoot.Controller.WareHouseRestController;

import com.example.WareHouseSpringBoot.DTO.ApiResponse;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.WareHouse;
import com.example.WareHouseSpringBoot.Service.WareHouseService.WareHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/action")
@Slf4j
public class WareHouseRestController {

    @Autowired
    WareHouseService wareHouseService;

    @PostMapping
    public ApiResponse<WareHouse> addWareHouse(@RequestBody WareHouse wareHouse) {
        return ApiResponse.<WareHouse>builder()
                .result(wareHouseService.save(wareHouse))
                .build();
    }

    @GetMapping
    public ApiResponse<Iterator<WareHouse>> getAllWareHouses() {
       return ApiResponse.<Iterator<WareHouse>>builder()
               .result(wareHouseService.findAll())
               .build();
    }

//    @PostMapping
//    public ApiResponse<WareHouse> updateWareHouse(@RequestBody WareHouse wareHouse) {
//
//    }

}
