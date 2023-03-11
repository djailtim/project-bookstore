package com.example.projectbookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String category;
    private Integer pages;
    private Integer yearPublication;
    private String type;

    public Book() {
    }

    public Book(String title, String author, String category, Integer pages, Integer yearPublication, String type) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.pages = pages;
        this.yearPublication = yearPublication;
        this.type = type;
    }

    public Book(Long id, String title, String author, String category, Integer pages, Integer yearPublication, String type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.pages = pages;
        this.yearPublication = yearPublication;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(Integer yearPublication) {
        this.yearPublication = yearPublication;
    }
}
