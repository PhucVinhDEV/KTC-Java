package com.example.WareHouseSpringBoot.Service.WareHouseService.Implement;

import com.example.WareHouseSpringBoot.Entity.ProductAttibute.Attribute;
import com.example.WareHouseSpringBoot.Repository.WareHouseRepository.AttributeRepository;
import com.example.WareHouseSpringBoot.Service.WareHouseService.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@Lazy
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeRepository attributeRepository;

    @Override
    public Attribute findById(String id) {
        return attributeRepository.findById(id).orElseThrow(() -> new RuntimeException("Attribute not found"));
    }

    @Override
    public Attribute save(Attribute entity) {
        return attributeRepository.save(entity);
    }

    @Override
    public Attribute update(Attribute entity) {
        return attributeRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
         attributeRepository.deleteById(id);
    }

    @Override
    public Iterator<Attribute> findAll() {
        return attributeRepository.findAll().iterator();
    }
}
