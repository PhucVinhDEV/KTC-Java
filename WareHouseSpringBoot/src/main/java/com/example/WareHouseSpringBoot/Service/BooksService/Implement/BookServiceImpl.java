package com.example.WareHouseSpringBoot.Service.BooksService.Implement;

import com.example.WareHouseSpringBoot.DTO.Mapper.BookMapper;
import com.example.WareHouseSpringBoot.DTO.PageRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.BookReponesesDTO;
import com.example.WareHouseSpringBoot.Entity.Book.Books;
import com.example.WareHouseSpringBoot.Entity.IModelPaginate;
import com.example.WareHouseSpringBoot.Entity.PageAble;
import com.example.WareHouseSpringBoot.Repository.BookRepository.BooksRepository;
import com.example.WareHouseSpringBoot.Service.BooksService.BookService;
import com.example.WareHouseSpringBoot.Utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    BookMapper bookMapper;





    @Override
    public IModelPaginate<List<BookReponesesDTO>> getAllBooksAndSort(PageRequest pageRequest) {
        List<BookReponesesDTO> books = booksRepository.findAll().stream().map(bookMapper::convertBookToBookReponesesDTO)
                .collect(Collectors.toList());
        int totalPages = (books.size() + Global.size_page - 1) /  Global.size_page;

        // Sắp xếp
        if ("desc".equalsIgnoreCase(pageRequest.getSortDirection())) {
            books.sort(Comparator.comparing(book ->  getSortValue((BookReponesesDTO) book, pageRequest.getSortBy())).reversed());
        } else {
            books.sort(Comparator.comparing(book ->  getSortValue(book, pageRequest.getSortBy())));
        }
        // Phân trang
        int start = pageRequest.getPage() * Global.size_page;
        int end = Math.min(start + Global.size_page, books.size());

        PageAble pageable = new PageAble(pageRequest.getPage(), Global.size_page, totalPages, books.size());
        if(pageRequest.getPage()<totalPages) {
            List<BookReponesesDTO> pagedBooks = books.subList(start, end).stream().toList();

            return IModelPaginate.<List<BookReponesesDTO>>builder()
                    .meta(pageable)
                    .result(pagedBooks)
                    .build();
        }else {

            return IModelPaginate.<List<BookReponesesDTO>>builder()
                    .meta(pageable)
                    .result(List.of())
                    .build();
        }

    }

    @Override
    public BookReponesesDTO findByBookReponesesId(Long id) {
        return bookMapper.convertBookToBookReponesesDTO(booksRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Books not find")));
    }

    @Override
    public List<BookReponesesDTO> findByBookName(String bookname) {
        return booksRepository.findAllByBookName(bookname).stream()
                .map(bookMapper::convertBookToBookReponesesDTO).toList();
    }

    @Override
    public List<BookReponesesDTO> findByRangeDate(LocalDateTime startDate, LocalDateTime endDate) {
        return booksRepository.findAll().stream()
                .filter(book -> !book.getCreatedDate().isBefore(startDate) && !book.getCreatedDate().isAfter(endDate))
                .map(bookMapper::convertBookToBookReponesesDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Books findById(Long id) {
        return booksRepository.findById(id).orElseThrow(()-> new RuntimeException("Books not find"));
    }

    @Override
    public Books save(Books entity) {
        return booksRepository.save(entity);
    }

    @Override
    public Books update(Books entity) {
        if (booksRepository.existsById(entity.getBookId())) {
            return booksRepository.save(entity);
        } else {
            throw new RuntimeException("Books not found");
        }
    }

    @Override
    public void deleteById(Long id) {
        if (!booksRepository.existsById(id)) throw new RuntimeException("Books not find");
        booksRepository.deleteById(id);
    }

    @Override
    public Iterator<Books> findAll() {
        return booksRepository.findAll().iterator();
    }

    private Comparable getSortValue(BookReponesesDTO book, String sortBy) {
        return switch (sortBy) {
            case Global.BOOK_NAME -> book.getBookName();
            case Global.QUANTITY -> book.getQuantity();
            case Global.PRICE -> book.getPrice();
            case Global.IS_AVAILABLE -> book.isIsAvailable();
            case Global.CREATED_BY -> book.getCreatedBy();
            case Global.CREATED_DATE -> book.getCreatedDate();
            case Global.LAST_MODIFIED_BY -> book.getLastModifiedBy();
            case Global.LAST_MODIFIED_DATE -> book.getLastModifiedDate();
            case Global.SELL_QUANTITY -> book.getSellQuantity();
            default -> book.getBookId();
        };
    }
}
