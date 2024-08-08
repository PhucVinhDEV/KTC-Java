package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.RoleRequest;

import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.RoleReponese;
import com.example.WareHouseSpringBoot.Entity.Auth.Permission;
import com.example.WareHouseSpringBoot.Entity.Auth.Role;

import com.example.WareHouseSpringBoot.Repository.AuthRepository.PermissionRepository;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleMapper {
   @Autowired
   ModelMapper modelMapper;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    PermissionMapper permissionMapper;

    public  Role ConvertToEntity(RoleRequest request) {
        Role role = modelMapper.map(request, Role.class);
        List<Permission> permissions =  permissionRepository.findAllById(request.getPermissions());
        Set<Permission> permissionSet = new HashSet<>(permissions);
        role.setPermissions(permissionSet);
        return role;
    }

    public  RoleReponese ConvertToReponese(Role role) {
        RoleReponese reponese = modelMapper.map(role, RoleReponese.class);
        reponese.setPermissions(role.getPermissions().stream().map(permissionMapper::convertToReponese).collect(Collectors.toSet()));
        return  reponese;
    }
}
