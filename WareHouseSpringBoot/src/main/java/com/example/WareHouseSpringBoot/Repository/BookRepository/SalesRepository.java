package com.example.WareHouseSpringBoot.Repository.BookRepository;

import com.example.WareHouseSpringBoot.Entity.Book.Books;
import com.example.WareHouseSpringBoot.Entity.Book.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findByBook(Books book);
}
