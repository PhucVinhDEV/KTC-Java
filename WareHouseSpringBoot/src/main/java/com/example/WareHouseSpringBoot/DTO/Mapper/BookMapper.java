package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.BookReponesesDTO;
import com.example.WareHouseSpringBoot.Entity.Book.Books;
import com.example.WareHouseSpringBoot.Entity.Book.Sales;
import com.example.WareHouseSpringBoot.Repository.BookRepository.BooksRepository;
import com.example.WareHouseSpringBoot.Repository.BookRepository.SalesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
public class BookMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SalesRepository salesRepository;

    public BookReponesesDTO convertBookToBookReponesesDTO(Books book) {
        BookReponesesDTO bookReponesesDTO =  modelMapper.map(book, BookReponesesDTO.class);
        bookReponesesDTO.setSellQuantity(SellQuantity(book));
        return  bookReponesesDTO;
    }

    protected int SellQuantity(Books book) {
      return salesRepository.findByBook(book).stream().mapToInt(Sales::getQuantity).sum();
    }
}
