package com.example.WareHouseSpringBoot.Service;

import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public interface BaseService<T,V> {

    T findById(V id);

    T save(T entity);

    T update(T entity);

    void deleteById(V id);

    Iterator<T> findAll();

}
