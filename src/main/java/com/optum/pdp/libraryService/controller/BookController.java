package com.optum.pdp.libraryService.controller;

import com.optum.pdp.libraryService.model.DTO.BookDTO;
import com.optum.pdp.libraryService.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getBookList() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO newBook) {
        BookDTO savedBook = bookService.addNewBook(newBook);
        return savedBook;
    }
}
