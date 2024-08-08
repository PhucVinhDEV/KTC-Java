package com.example.WareHouseSpringBoot.Controller;

import com.example.WareHouseSpringBoot.DTO.ApiResponse;
import com.example.WareHouseSpringBoot.DTO.Mapper.PermissionMapper;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.PermissionRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.PermissionReponese;
import com.example.WareHouseSpringBoot.Entity.Auth.Permission;
import com.example.WareHouseSpringBoot.Service.AuthService.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionRestController{

    @Autowired
    PermissionService permissionService;

    @Autowired
    PermissionMapper permissionMapper;

    @PostMapping
    public ApiResponse addPermission(@RequestBody PermissionRequest permissionRequest){
        return ApiResponse.builder()
                .result(permissionService.save(permissionMapper.ConvertToEntity(permissionRequest)))
                .message("Permission Created Successfully")
                .status(201)
                .build();
    }

    @GetMapping
    public ApiResponse<List<PermissionReponese>> getAllPermission(){
        return ApiResponse.<List<PermissionReponese>>builder()
                .status(201)
                .message("Get All Permission Successfully")
                .result(permissionService.GetAllPermission())
                .build();
    }
}
