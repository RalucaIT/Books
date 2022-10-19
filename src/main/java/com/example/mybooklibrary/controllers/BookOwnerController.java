package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.services.BookOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/bookOwner")
@RestController
public class BookOwnerController {
    @Autowired // prin Spring, leg Controller-ul de (crearea noii instante de) BookOwnerService.
    private BookOwnerService bookOwnerService;

    //get, post, put, delete, head
    @RequestMapping(method = RequestMethod.POST)
    public BookOwner createBookOwner(@RequestParam Long bookId, @RequestParam Long userId) {
        return bookOwnerService.createBookOwner(bookId, userId);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/showBookOwners")
    public List<BookOwner> getBookOwner() {
        return bookOwnerService.getBookOwner();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/available")
    public List<Book> getAvailableBooks() {
        return bookOwnerService.getAvailableBooks();
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/available")
//    public List<BookOwner> getAvailableBooks() {
//        return bookOwnerService.getAvailableBooks();
//    }
    // here I wrote the method for all Available Books to be shown.
//    @RequestMapping(method = RequestMethod.POST, path = "/addBook")
//    public Book addBookByUser(@RequestBody Book book, @RequestParam("ownerId") Long userId) {
//        return bookOwnerService.addBookByUser(book, userId);
//    }
}
