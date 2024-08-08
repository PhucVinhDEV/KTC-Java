package com.example.WareHouseSpringBoot.Config;

import com.example.WareHouseSpringBoot.Contant.PredefineRole;
import com.example.WareHouseSpringBoot.Entity.Auth.Permission;
import com.example.WareHouseSpringBoot.Entity.Auth.Role;
import com.example.WareHouseSpringBoot.Entity.Auth.User;

import com.example.WareHouseSpringBoot.Repository.AuthRepository.PermissionRepository;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.RoleRepository;
import com.example.WareHouseSpringBoot.Repository.AuthRepository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationConfig {

    @NonFinal
    static final String ADMIN_USER_NAME = "admin";

    @NonFinal
    static final String ADMIN_PASSWORD = "admin";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Bean
    ApplicationRunner applicationRunner(PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                // Tạo các quyền CRUD
                createPermissionIfNotExists(PredefineRole.CREATE_PERMISSION, "Create permission");
                createPermissionIfNotExists(PredefineRole.UPDATE_PERMISSION, "Update permission");
                createPermissionIfNotExists(PredefineRole.DELETE_PERMISSION, "Delete permission");
                createPermissionIfNotExists(PredefineRole.READ_PERMISSION, "Read permission");

// Tạo role với các quyền CRUD
                Role adminRole = roleRepository.save(Role.builder()
                        .name(PredefineRole.ADMIN_ROLE)
                        .description("Admin role")
                        .permissions(Set.of(
                                permissionRepository.findById(PredefineRole.CREATE_PERMISSION).orElseThrow(),
                                permissionRepository.findById(PredefineRole.UPDATE_PERMISSION).orElseThrow(),
                                permissionRepository.findById(PredefineRole.DELETE_PERMISSION).orElseThrow(),
                                permissionRepository.findById(PredefineRole.READ_PERMISSION).orElseThrow()
                        ))
                        .build());

                Role userRole = roleRepository.save(Role.builder()
                                .name(PredefineRole.USER_ROLE)
                                .description("User role")
                                .permissions(Set.of(
                                        permissionRepository.findById(PredefineRole.CREATE_PERMISSION).orElseThrow(),
                                        permissionRepository.findById(PredefineRole.UPDATE_PERMISSION).orElseThrow(),
                                        permissionRepository.findById(PredefineRole.READ_PERMISSION).orElseThrow()
                                ))
                        .build());

                Role customerRole = roleRepository.save(Role.builder()
                        .name(PredefineRole.CUSTOMER_ROLE)
                        .description("Customer role")
                        .permissions(Set.of(
                                permissionRepository.findById(PredefineRole.CREATE_PERMISSION).orElseThrow(),
                                permissionRepository.findById(PredefineRole.READ_PERMISSION).orElseThrow()
                        ))
                        .build());

                // Tạo user với role admin
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);

                User user = User.builder()
                        .username(ADMIN_USER_NAME)
                        .password(passwordEncoder.encode(ADMIN_PASSWORD))
                        .roles(roles)
                        .build();
                userRepository.save(user);

                log.warn("admin user has been created with default password: admin, please change it");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    // Phương thức tạo quyền nếu chưa tồn tại
    private void createPermissionIfNotExists(String name, String description) {
        if (!permissionRepository.existsById(name)) {
            permissionRepository.save(Permission.builder()
                    .name(name)
                    .description(description)
                    .build());
        }
    }



}
