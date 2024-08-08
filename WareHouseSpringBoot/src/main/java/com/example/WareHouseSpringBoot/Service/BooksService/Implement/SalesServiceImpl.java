package com.example.WareHouseSpringBoot.Service.BooksService.Implement;

import com.example.WareHouseSpringBoot.DTO.Mapper.SaleMapper;
import com.example.WareHouseSpringBoot.DTO.RequestDTO.SalesRequestDTO;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.SaleReponeseDTO;
import com.example.WareHouseSpringBoot.Entity.Book.Books;
import com.example.WareHouseSpringBoot.Entity.Book.Sales;
import com.example.WareHouseSpringBoot.Repository.BookRepository.BooksRepository;
import com.example.WareHouseSpringBoot.Repository.BookRepository.SalesRepository;
import com.example.WareHouseSpringBoot.Service.BooksService.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
@Lazy
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    SaleMapper saleMapper;

    @Override
    public Sales findById(Long id) {
        return salesRepository.findById(id).orElseThrow(() -> new RuntimeException("Sales not found"));
    }

    @Override
    public Sales save(Sales entity) {

        return salesRepository.save(entity);
    }

    @Override
    public Sales update(Sales entity) {
        return salesRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        salesRepository.deleteById(id);
    }

    @Override
    public Iterator<Sales> findAll() {
        return salesRepository.findAll().iterator();
    }

    @Override
    public SaleReponeseDTO sale(SalesRequestDTO requestDTO) {
        Books books = booksRepository.findById(requestDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Books not found"));
        if(requestDTO.getQuantity() > books.getQuantity()) throw new RuntimeException("not enough book for you !");
        books.setQuantity(books.getQuantity() - requestDTO.getQuantity());
        booksRepository.save(books);
        return saleMapper.ConvertToDTO(salesRepository.save(saleMapper.ConvertToEntity(requestDTO)));
    }
}
