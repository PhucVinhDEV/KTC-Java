package com.example.WareHouseSpringBoot.Repository.WareHouseRepository;

import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductBigdecimal;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductDate;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.AttributeProductInteger;
import com.example.WareHouseSpringBoot.Entity.ProductAttibute.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeProductBigdecimalRepository extends JpaRepository<AttributeProductBigdecimal, Long> {
    List<AttributeProductBigdecimal> findAllByProduct(Product product);

}
