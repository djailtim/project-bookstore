package com.example.projectbookstore.controllers;

import com.example.projectbookstore.model.Book;
import com.example.projectbookstore.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/add-book")
    public String createBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add-books";
    }

    @PostMapping("/add")
    public String addBook(Book book){
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }


}
