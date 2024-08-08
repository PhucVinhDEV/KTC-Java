package com.example.WareHouseSpringBoot.Service.AuthService.Implement;

import com.example.WareHouseSpringBoot.DTO.Mapper.PermissionMapper;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.PermissionRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.PermissionReponese;
import com.example.WareHouseSpringBoot.Entity.Auth.Permission;
import com.example.WareHouseSpringBoot.Exception.AppException;
import com.example.WareHouseSpringBoot.Exception.ErrorCode;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.PermissionRepository;
import com.example.WareHouseSpringBoot.Service.AuthService.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Lazy
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public Permission findById(String id) {
        return permissionRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
    }

    @Override
    public Permission save(Permission entity) {
        return permissionRepository.save(entity);
    }

    @Override
    public Permission update(Permission entity) {
        return permissionRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public Iterator<Permission> findAll() {
        return permissionRepository.findAll().iterator();
    }

    @Override
    public List<PermissionReponese> GetAllPermission() {
        return permissionRepository.findAll().stream()
                .map(permissionMapper::convertToReponese).collect(Collectors.toList());
    }

    @Override
    public PermissionReponese create(PermissionRequest request) {
        Permission permission = permissionMapper.ConvertToEntity(request);
        permissionRepository.save(permission);
        return permissionMapper.convertToReponese(permission);
    }
}
