package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/books")
public class BookController {
    @Autowired // prin Spring, leg Controller-ul de (crearea noii instante de) BookService.
    private BookService bookService;

    //get, post, put, delete, head
    @RequestMapping(method = RequestMethod.POST, path = "/add_book") // creez 1 book.
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/add_book").toUriString());
        return ResponseEntity.created(uri).body(bookService.createBook(book));
        // return bookService.createBook(book); // (ma folosesc de userId ca sa stiu cine a creat cartea)
    }

    @RequestMapping(method = RequestMethod.GET, path = "/show_books") // doar returnez/vad books, NU creez nimic.
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> userBook=bookService.getBooks();
        return new ResponseEntity<>(userBook, HttpStatus.OK);
    }
//    public List<Book> getBooks() {
//        return bookService.getBooks();
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<List<Book>> getBookByTitleOrAuthor(@RequestParam("title") String title, @RequestParam("author") String author) {
        List<Book> userBook=bookService.getBookByTitleOrAuthor(title, author);
        return new ResponseEntity<>(userBook, HttpStatus.OK);

        // return ResponseEntity<bookService> getBookByTitleOrAuthor(title, author);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/available")
    public ResponseEntity <List<Book>> getAvailableBooks() {
        List<Book> userBook=bookService.getAvailableBooks();
        return new ResponseEntity<>(userBook, HttpStatus.OK);

        // return bookService.getAvailableBooks();
    }
}

// definesc path-ul si apelez fct din service, ce apeleaza fct din tabele / repo-uri.