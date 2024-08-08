package com.example.WareHouseSpringBoot.Repository.AuthRepository;

import com.example.WareHouseSpringBoot.Entity.Auth.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {

    boolean existsById(String s);
}
