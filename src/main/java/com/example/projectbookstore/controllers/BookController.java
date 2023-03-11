package com.example.projectbookstore.controllers;

import com.example.projectbookstore.model.Book;
import com.example.projectbookstore.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllBooks(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "index";
    }
}
