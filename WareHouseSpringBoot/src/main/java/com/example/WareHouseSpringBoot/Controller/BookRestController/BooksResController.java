package com.example.WareHouseSpringBoot.Controller.BookRestController;

import com.example.WareHouseSpringBoot.DTO.ApiResponse;
import com.example.WareHouseSpringBoot.DTO.PageRequest;
import com.example.WareHouseSpringBoot.DTO.ResponeseDTO.BookReponesesDTO;
import com.example.WareHouseSpringBoot.Entity.Book.Books;
import com.example.WareHouseSpringBoot.Entity.IModelPaginate;
import com.example.WareHouseSpringBoot.Service.BooksService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Book")
public class BooksResController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ApiResponse addBook(@RequestBody Books book) {
        return ApiResponse.builder()
                .status(201)
                .message("Created Book Successfully")
                .result(bookService.save(book))
                .build();
    }

    @PutMapping
    public ApiResponse updateBook(@RequestBody Books book) {
        return ApiResponse.builder()
                .status(201)
                .message("Created Book Successfully")
                .result(bookService.update(book))
                .build();
    }


    @DeleteMapping
    public ApiResponse deleteBook(@RequestBody Books book) {
        bookService.deleteById(book.getBookId());
        return ApiResponse.builder()
                .result(201)
                .build();
    }

    @GetMapping
    public ApiResponse<IModelPaginate<List<BookReponesesDTO>>> getAllBooks(@RequestBody PageRequest PageRequest) {
        return ApiResponse.<IModelPaginate<List<BookReponesesDTO>>>builder()
                .message("GetAll Boos Successfully")
                .result(
                        bookService.getAllBooksAndSort(PageRequest)
                )
                .status(201)
                .build();
    }

    @GetMapping("/ById")
    public ApiResponse<BookReponesesDTO> getBookById(@RequestParam("id") long id) {
        return ApiResponse.<BookReponesesDTO>builder()
                .message("Get Book Successfully")
                .status(201)
                .result(bookService.findByBookReponesesId(id))
                .build();
    }

        @GetMapping("/ByBookname")
        public ApiResponse<List<BookReponesesDTO>> getBookByBookname(@RequestParam("bookname") String bookname) {
            return ApiResponse.<List<BookReponesesDTO>>builder()
                    .message("Get Book Successfully")
                    .status(201)
                    .result(bookService.findByBookName(bookname))
                    .build();
        }

        @GetMapping("/RangeDate")
        public ApiResponse<List<BookReponesesDTO>> getBookByRangeDate(@RequestParam("StartDate") LocalDateTime start, @RequestParam("EndDate") LocalDateTime end) {
            return ApiResponse.<List<BookReponesesDTO>>builder()
                    .message("Get Book Successfully")
                    .status(201)
                    .result(bookService.findByRangeDate(start, end))
                    .build();
        }
}
