package com.optum.pdp.libraryService.service;

import com.optum.pdp.libraryService.model.DTO.BookDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    private List<BookDTO> bookEntities = new ArrayList<>(Arrays.asList(
            new BookDTO("1", "Brave New World", "Aldous Huxley", "sci-fi"),
            new BookDTO("2", "Modern Java in Action", "Alan Mycroft", "tech"),
            new BookDTO("3", "Design Pattern", "Eric Gamma", "tech"),
            new BookDTO("4", "Nineteen Eighty-Four", "George Orwell", "fictional"),
            new BookDTO("5", "A Brief History of Time", "Stephen Hawking", "non-fictional"))
    );

    public List<BookDTO> getAllBooks() {
        return bookEntities;
    }

    public BookDTO addNewBook(BookDTO newBook) {
        this.bookEntities.add(newBook);
        return newBook;
    }
}
