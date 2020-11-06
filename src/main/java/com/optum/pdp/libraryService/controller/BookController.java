package com.optum.pdp.libraryService.controller;

import com.optum.pdp.libraryService.model.DTO.BookDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private List<BookDTO> bookEntities = List.of(
            new BookDTO("1", "Brave New World", "Aldous Huxley", "sci-fi"),
            new BookDTO("2", "Modern Java in Action", "Alan Mycroft", "tech"),
            new BookDTO("3", "Design Pattern", "Eric Gamma", "tech"),
            new BookDTO("4", "Nineteen Eighty-Four", "George Orwell", "fictional"),
            new BookDTO("5", "A Brief History of Time", "Stephen Hawking", "non-fictional")
    );


    @GetMapping("/books")
    public List<BookDTO> getBookList() {
        return bookEntities;
    }
}
