package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.UserCreateRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.UserUpdateRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.RoleReponese;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.UserReponeseDTO;
import com.example.WareHouseSpringBoot.Entity.Auth.Role;
import com.example.WareHouseSpringBoot.Entity.Auth.User;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private static final Logger log = LoggerFactory.getLogger(UserMapper.class);
    @Autowired
    ModelMapper modelMapper;


    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User UserCreateconvertToEntity(UserCreateRequest request) {
        User u = modelMapper.map(request, User.class);
        u.setPassword(passwordEncoder.encode(request.getPassword()));
        return u;
    }

    public User UserUpdateconvertToEntity(UserUpdateRequest request, RoleRepository rolerepository, PasswordEncoder passwordencoder) {
        User u = modelMapper.map(request, User.class);

        //get ra all role theo id
        var roles = rolerepository.findAllById(request.getRoles());
        u.setPassword(passwordencoder.encode(request.getPassword()));
        //convert to Set
        Set<Role> roleSet = new HashSet<>(roles);

        u.setRoles(roleSet);
        return u;
    }

    public  UserReponeseDTO convertUserToReponese(User user) {
        UserReponeseDTO u = modelMapper.map(user, UserReponeseDTO.class);
        Set<RoleReponese> roles = user.getRoles().stream().map(roleMapper::ConvertToReponese).collect(Collectors.toSet());
        u.setRoles(roles);
        return u;
    }
}
