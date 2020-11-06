# Purpose

This lab will introduce REST concepts in Spring Boot framework. You will use  [Spring Boot Initializer](http://start.spring.io/)  to initiate an app.


The Spring Initializr is ultimately a web application that can generate a Spring Boot project structure for you. It doesn’t generate any application code, but it will give you a basic project structure and either a Maven or a Gradle build specification to build your code with



# Learning Outcomes

After completing the lab you will be able to

- Initiate Spring Boot application using Spring Initializer.
- Add REST controller to the application.
- Run the application
- Invoke REST endpoints and interact with the application

Estimated Time To Complete: 15 minutes

# How to complete this guide

you can start from scratch and complete each step or you can bypass basic setup steps that are already familiar to you. Either way, you end up with working code.

- To  **start from scratch**, move on to  [Starting with Spring Initializr](https://spring.io/guides/gs/spring-boot/#scratch).
	- You should be able to see the following webpage
![enter image description here](https://learnjava.co.in/wp-content/uploads/2020/04/SpringInitilizr1-1-768x394.png)
	- add `web`, `JPA` and `H2` as dependency.
	- choose `Gradle Project` as build system.
	- click on `Generate` to download initiated application.


To  **skip the basics**, do the following:
- logging in to your workshop terminal at https://hue.providerdataplatform.net/guacamole
- run the following command to download workshop codes to your environment
	- `git clone https://github.optum.com/EnterpriseProviderPlatform/dev-days-2020-spring-boot.git`
- at this point you have downloaded all labs to your environment. Run the following command to navigate to `lab1`
	- `cd dev-days-2020-spring-boot/lab1`
	- [Check out](https://git-scm.com/docs/git-checkout) to the `lab1-start-point` by running the following: `git checkout lab1-start-point`
# Starting point

Check out to the  `lab1-start-point`  tag.





## REST Controllers

### GET Endpoint

```
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
```
Check out to the `lab1-book-controller-get` tag

### POST Endpoint
```
@PostMapping  
public BookDTO addBook(@RequestBody BookDTO newBook) {  
    bookEntities.add(newBook);  
 return newBook;  
}
```
Check out to the `lab1-book-controller-post` tag

### PUT Endpoint

### DELETE Endpoint

## Service Layer

```
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
```

Check out to the lag `lab1-bookService`

## Repository Layer
```
package com.optum.pdp.libraryService.repository;  
  
import com.optum.pdp.libraryService.model.entity.BookEntity;  
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;  
  
@Repository  
public interface BookRepository extends JpaRepository<BookEntity, String> {  
}
```

Check out to the tag `lab1-repository`

