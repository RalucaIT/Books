package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookDto;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.services.BookOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public List<BookOwner> getBookOwner() {
        return bookOwnerService.getBookOwner();
    }

//    @RequestMapping(method = RequestMethod.POST, path = "/addBook")
//    public Book addBookByUser(@RequestBody Book book, @RequestParam("ownerId") Long userId) {
//        return bookOwnerService.addBookByUser(book, userId);
//    }
}
