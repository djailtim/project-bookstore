package com.example.projectbookstore.services;

import com.example.projectbookstore.model.Book;
import org.springframework.stereotype.Service;

import com.example.projectbookstore.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        book.setTitle(book.getTitle().toLowerCase());
        book.setAuthor(book.getAuthor().toLowerCase());
        book.setCategory(book.getCategory().toLowerCase());
        book.setType(book.getType().toLowerCase());
        return bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->new RuntimeException("Livro não encontrado."));
    }

    public Book edit(Long id, Book book) {
        Optional<Book> bookFound = bookRepository.findById(id);
        if(bookFound.isEmpty()) {
            throw new RuntimeException("Livro não encontrado!");
        }
        book.setId(id);
        return save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findByTitle(String title) {
        Optional<Book> bookFound = Optional.ofNullable(bookRepository.findByTitleContains(title));
        if(bookFound.isEmpty()) {
            throw new RuntimeException("Livro não encontrado!");
        }
        return bookRepository.findByTitleContains(title);
    }
}
