package com.example.WareHouseSpringBoot.DTO.Mapper;

import com.example.WareHouseSpringBoot.DTO.RequestDTO.SalesRequestDTO;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.BookReponesesDTO;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.SaleReponeseDTO;
import com.example.WareHouseSpringBoot.Entity.Book.Sales;
import com.example.WareHouseSpringBoot.Repository.BookRepository.BooksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Lazy
public class SaleMapper {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BooksRepository booksRepository;

    public Sales ConvertToEntity(SalesRequestDTO requestDTO) {
        Sales sales = modelMapper.map(requestDTO, Sales.class);
        sales.setBook(booksRepository.findById(requestDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found")));
        return sales;
    }

    public SaleReponeseDTO ConvertToDTO(Sales sales) {
        SaleReponeseDTO responseDTO = modelMapper.map(sales, SaleReponeseDTO.class);
        BookReponesesDTO bookReponesesDTO = bookMapper.convertBookToBookReponesesDTO(sales.getBook());
        responseDTO.setBookReponesesDTO(bookReponesesDTO);
        // Tính toán totalPrice sử dụng BigDecimal
        BigDecimal price = bookReponesesDTO.getPrice();
        BigDecimal quantity = new BigDecimal(sales.getQuantity());
        BigDecimal totalPrice = price.multiply(quantity);
        responseDTO.setTotalPrice(totalPrice);
        return responseDTO;
    }
}
