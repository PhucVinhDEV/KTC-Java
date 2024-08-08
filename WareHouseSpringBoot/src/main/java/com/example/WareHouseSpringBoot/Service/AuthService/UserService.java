package com.example.WareHouseSpringBoot.Service.AuthService;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.UserCreateRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.UserUpdateRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.UserReponeseDTO;
import com.example.WareHouseSpringBoot.Entity.Auth.User;
import com.example.WareHouseSpringBoot.Service.BaseService;

import java.util.List;

public interface UserService extends BaseService<User,String> {
    UserReponeseDTO createUser(UserCreateRequest request);

    UserReponeseDTO getMyInfo();

    User getUserById(String id);

    User updateUser(UserUpdateRequest request);

    void deleteUser(String id);

    boolean existsByUsername(String username);

    List<UserReponeseDTO> GetAllUser();
}
