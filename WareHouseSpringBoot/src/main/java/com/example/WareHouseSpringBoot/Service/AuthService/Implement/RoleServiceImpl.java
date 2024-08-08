package com.example.WareHouseSpringBoot.Service.AuthService.Implement;

import com.example.WareHouseSpringBoot.DTO.Mapper.RoleMapper;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.RoleRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.RoleReponese;
import com.example.WareHouseSpringBoot.Entity.Auth.Role;
import com.example.WareHouseSpringBoot.Exception.AppException;
import com.example.WareHouseSpringBoot.Exception.ErrorCode;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.RoleRepository;
import com.example.WareHouseSpringBoot.Service.AuthService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
@Lazy
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role findById(String id) {
        return roleRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
    }

    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role update(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Iterator<Role> findAll() {
        return roleRepository.findAll().iterator();
    }
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RoleReponese create(RoleRequest request) {
        Role role = roleMapper.ConvertToEntity(request);
        roleRepository.save(role);
        return roleMapper.ConvertToReponese(role);
    }
}
