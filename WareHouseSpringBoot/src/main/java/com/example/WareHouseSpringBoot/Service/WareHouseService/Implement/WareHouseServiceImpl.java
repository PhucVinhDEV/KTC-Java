package com.example.WareHouseSpringBoot.Service.WareHouseService.Implement;

import com.example.WareHouseSpringBoot.Entity.ProductAttibute.WareHouse;
import com.example.WareHouseSpringBoot.Repository.WareHouseRepository.WareHouseRepository;
import com.example.WareHouseSpringBoot.Service.WareHouseService.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    WareHouseRepository wareHouseRepository;


    @Override
    public WareHouse findById(Long id) {
        return wareHouseRepository.findById(id).orElseThrow(() -> new RuntimeException("WareHouse not found !"));
    }

    @Override
    public WareHouse save(WareHouse entity) {
        return wareHouseRepository.save(entity);
    }

    @Override
    public WareHouse update(WareHouse entity) {
        return wareHouseRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        wareHouseRepository.deleteById(id);
    }

    @Override
    public Iterator<WareHouse> findAll() {
        return wareHouseRepository.findAll().iterator();
    }
}
