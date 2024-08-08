package com.example.WareHouseSpringBoot.Service.AuthService.Implement;

import com.example.WareHouseSpringBoot.Contant.PredefineRole;
import com.example.WareHouseSpringBoot.DTO.Mapper.UserMapper;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.UserCreateRequest;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.UserUpdateRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.UserReponeseDTO;
import com.example.WareHouseSpringBoot.Entity.Auth.Role;
import com.example.WareHouseSpringBoot.Entity.Auth.User;
import com.example.WareHouseSpringBoot.Exception.AppException;
import com.example.WareHouseSpringBoot.Exception.ErrorCode;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.RoleRepository;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.UserRepository;
import com.example.WareHouseSpringBoot.Service.AuthService.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserReponeseDTO createUser(UserCreateRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) throw new AppException(ErrorCode.UserExitsted);
        // Convert the UserRequest to a User entity
        User user = userMapper.UserCreateconvertToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        roleRepository.findById(PredefineRole.USER_ROLE).ifPresent(roles::add);

        user.setRoles(roles);
        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception){
            throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
        // Return the saved user entity
        return userMapper.convertUserToReponese(user);

    }

    @Override
    public UserReponeseDTO getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.convertUserToReponese(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found !"));
    }

    @Override
//    @PostAuthorize("returnObject.username == authentication.name")
    public User updateUser(UserUpdateRequest request) {
        User user = userMapper.UserUpdateconvertToEntity(request,roleRepository,passwordEncoder);
        return userRepository.save(user);
    }

    @Override
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }


    @Override
//    @PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("hasAuthority('READ_PERMISSION')")
    public List<UserReponeseDTO> GetAllUser() {
        log.info("In method get All Users");
        return userRepository.findAll().stream().map(userMapper::convertUserToReponese).toList();
    }


    @Override
    public User findById(String id) {
        return userRepository.findByUsername(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }


    @Override
    public Iterator<User> findAll() {
        return userRepository.findAll().iterator();
    }
}
