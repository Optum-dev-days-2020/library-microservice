package com.optum.pdp.libraryService;

import com.optum.pdp.libraryService.model.entity.BookEntity;
import com.optum.pdp.libraryService.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LibraryServiceApplication implements CommandLineRunner {

	private BookRepository bookRepository;

	public LibraryServiceApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepository.saveAll( List.of(
				new BookEntity(1L, "Brave New World", "Aldous Huxley", "sci-fi"),
				new BookEntity(2L, "Modern Java in Action", "Alan Mycroft", "tech"),
				new BookEntity(3L, "Design Pattern", "Eric Gamma", "tech"),
				new BookEntity(4L, "Nineteen Eighty-Four", "George Orwell", "fictional"),
				new BookEntity(5L, "A Brief History of Time", "Stephen Hawking", "non-fictional"))
		);
	}
}
