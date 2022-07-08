package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/book")
public class BookController {
    @Autowired // prin Spring, leg Controller-ul de (crearea noii instante de) UserService.
    private BookService bookService;

    //get, post, put, delete, head
    @RequestMapping(method = RequestMethod.POST) // creez 1 user.
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @RequestMapping(method = RequestMethod.GET) // doar vad userii, NU creez nimic.
    public List<Book> getBook() {
        return bookService.getBook();
    }
}
