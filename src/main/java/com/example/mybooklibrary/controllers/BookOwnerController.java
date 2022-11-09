package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.services.BookOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping(path = "/bookOwner")
@RestController
public class BookOwnerController {
    @Autowired // prin Spring, leg Controller-ul de (crearea noii instante de) BookOwnerService.
    private BookOwnerService bookOwnerService;

    //get, post, put, delete, head
    @RequestMapping(method = RequestMethod.POST, path = "add_bookOwner")
    public ResponseEntity<BookOwner> createBookOwner(@RequestParam Long bookId,
                                                     @RequestParam Long userId) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/bookOwner/add_bookOwner").toUriString());
        return ResponseEntity.created(uri).body(bookOwnerService.createBookOwner(bookId, userId));
    }


    @RequestMapping(method = RequestMethod.GET, path = "/show_bookOwner") // doar returnez/vad books, NU creez nimic.
    public ResponseEntity<List<BookOwner>> getBookOwner() {
        List<BookOwner> bookOwner = bookOwnerService.getBookOwner();
        return new ResponseEntity<>(bookOwner, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/available")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        return new ResponseEntity(getAvailableBooks(), HttpStatus.OK);
    }
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

