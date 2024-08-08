package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.PermissionRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.PermissionReponese;
import com.example.WareHouseSpringBoot.Entity.Auth.Permission;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PermissionMapper {

    @Autowired
    ModelMapper modelMapper;


    public  Permission ConvertToEntity(PermissionRequest request){
        return modelMapper.map(request, Permission.class);
    }

    public  PermissionReponese convertToReponese(Permission permission){
        return modelMapper.map(permission, PermissionReponese.class);
    }
}
