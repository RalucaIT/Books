package com.example.mybooklibrary.services;


import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public Book createBook (Book book) {
        return bookRepository.saveAndFlush(book);
    }
    public List<Book> getBook() {
        return bookRepository.findAll();
    }
}
