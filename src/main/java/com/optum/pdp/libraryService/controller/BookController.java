package com.optum.pdp.libraryService.controller;

import com.optum.pdp.libraryService.model.DTO.BookDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private List<BookDTO> bookEntities = new ArrayList<>(Arrays.asList(
            new BookDTO("1", "Brave New World", "Aldous Huxley", "sci-fi"),
            new BookDTO("2", "Modern Java in Action", "Alan Mycroft", "tech"),
            new BookDTO("3", "Design Pattern", "Eric Gamma", "tech"),
            new BookDTO("4", "Nineteen Eighty-Four", "George Orwell", "fictional"),
            new BookDTO("5", "A Brief History of Time", "Stephen Hawking", "non-fictional"))
    );


    @GetMapping
    public List<BookDTO> getBookList() {
        return bookEntities;
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO newBook) {
        bookEntities.add(newBook);
        return newBook;
    }
}
