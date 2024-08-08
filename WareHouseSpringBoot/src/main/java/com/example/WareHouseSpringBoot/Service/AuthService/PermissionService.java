package com.example.WareHouseSpringBoot.Service.AuthService;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.PermissionRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.PermissionReponese;
import com.example.WareHouseSpringBoot.Entity.Auth.Permission;
import com.example.WareHouseSpringBoot.Service.BaseService;

import java.util.List;

public interface PermissionService extends BaseService<Permission,String> {
    List<PermissionReponese> GetAllPermission();
    PermissionReponese create(PermissionRequest request);
}
