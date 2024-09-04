package com.example.WareHouseSpringBoot.Repository.AuthRepository;

import com.example.WareHouseSpringBoot.Entity.Auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, String>  {

}
