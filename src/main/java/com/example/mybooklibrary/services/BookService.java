package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void createBook(Book book) {
       bookRepository.saveAndFlush(book);
    }

    public List<Book> getBooks() {

        return bookRepository.findAll();
    }

    public List<Book> getBookByTitleOrAuthor(Optional<String> title,Optional< String> author) {
        return bookRepository.findByTitleOrAuthor(title, author);
    }

}
