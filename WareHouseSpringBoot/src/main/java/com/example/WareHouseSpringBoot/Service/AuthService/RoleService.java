package com.example.WareHouseSpringBoot.Service.AuthService;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.RoleRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.RoleReponese;
import com.example.WareHouseSpringBoot.Entity.Auth.Role;
import com.example.WareHouseSpringBoot.Service.BaseService;

public interface RoleService extends BaseService<Role,String> {
    RoleReponese create(RoleRequest request);
}
