package com.example.WareHouseSpringBoot.Repository.WareHouseRepository;

import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductInteger;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeProductIntegerRepository extends JpaRepository<AttributeProductInteger, Long> {

    List<AttributeProductInteger> findAllByProduct(Product product);
}
