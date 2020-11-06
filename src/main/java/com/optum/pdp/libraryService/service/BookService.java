package com.optum.pdp.libraryService.service;

import com.optum.pdp.libraryService.model.DTO.BookDTO;
import com.optum.pdp.libraryService.model.entity.BookEntity;
import com.optum.pdp.libraryService.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> allBooks = bookRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return allBooks;
    }

    private BookDTO toDTO(BookEntity bookEntity) {
        return new BookDTO(bookEntity.getBookId(), bookEntity.getTitle(), bookEntity.getAuthor(), bookEntity.getCategory());
    }

    public BookDTO addNewBook(BookDTO newBook) {
        bookRepository.save(toEntity(newBook));
        return newBook;
    }

    private BookEntity toEntity(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity(bookDTO.getBookId(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getCategory());
        return bookEntity;
    }
}
