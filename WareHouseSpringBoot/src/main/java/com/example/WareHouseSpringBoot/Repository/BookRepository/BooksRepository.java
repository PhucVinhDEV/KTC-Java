package com.example.WareHouseSpringBoot.Repository.BookRepository;

import com.example.WareHouseSpringBoot.Entity.Book.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findAllByBookName(String bookName);
}
