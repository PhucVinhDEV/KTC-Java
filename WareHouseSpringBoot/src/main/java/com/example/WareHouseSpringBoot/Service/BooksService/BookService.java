package com.example.WareHouseSpringBoot.Service.BooksService;

import com.example.WareHouseSpringBoot.DTO.PageRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.BookReponesesDTO;
import com.example.WareHouseSpringBoot.Entity.Book.Books;
import com.example.WareHouseSpringBoot.Entity.IModelPaginate;
import com.example.WareHouseSpringBoot.Service.BaseService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BookService extends BaseService<Books,Long> {

        IModelPaginate<List<BookReponesesDTO>> getAllBooksAndSort(PageRequest pageRequest);
        BookReponesesDTO findByBookReponesesId(Long id);
        List<BookReponesesDTO> findByBookName(String bookname);
        List<BookReponesesDTO> findByRangeDate(LocalDateTime startDate, LocalDateTime endDate);
}
