package com.example.WareHouseSpringBoot.Repository.AuthRepository;

import com.example.WareHouseSpringBoot.Entity.Auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
