package com.example.WareHouseSpringBoot.Repository.WareHouseRepository;

import com.example.WareHouseSpringBoot.Entity.ProductAttibute.WareHouse;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {
}
