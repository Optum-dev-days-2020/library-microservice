package com.optum.pdp.libraryService.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BookEntity {

    @Id
    @GeneratedValue
    private long bookId;
    private String title;
    private String author;
    private String category;

    public BookEntity(){}

    public BookEntity(long bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
}
