package com.example.WareHouseSpringBoot.Repository.WareHouseRepository;

import com.example.WareHouseSpringBoot.Entity.ProductAttibute.Attribute;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
public interface AttributeRepository extends JpaRepository<Attribute, String> {

    Optional<Attribute> findById(String s);
}
