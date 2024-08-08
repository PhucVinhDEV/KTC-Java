package com.example.WareHouseSpringBoot.Repository.WareHouseRepository;

import com.example.WareHouseSpringBoot.Entity.ProductAttibute.Product;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long productID);
}
