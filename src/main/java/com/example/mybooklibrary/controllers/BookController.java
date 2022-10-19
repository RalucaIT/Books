package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/books")
public class BookController {
    @Autowired // prin Spring, leg Controller-ul de (crearea noii instante de) BookService.
    private BookService bookService;

    //get, post, put, delete, head
    @RequestMapping(method = RequestMethod.POST, path = "/add_book") // creez 1 book.
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book); // (ma folosesc de userId ca sa stiu cine a creat cartea)
    }

    @RequestMapping(method = RequestMethod.GET, path = "/show_books") // doar vad books, NU creez nimic.
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Book> getBookByTitleOrAuthor(@RequestParam("title") Optional<String> title, @RequestParam("author") Optional<String> author) {
        return bookService.getBookByTitleOrAuthor(title, author);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/available")
    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }
}

// definesc path-ul si apelez fct din service, ce apeleaza fct din tabele / repo-uri.