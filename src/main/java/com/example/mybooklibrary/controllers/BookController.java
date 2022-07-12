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
@RequestMapping ("/api/books")
public class BookController {
    @Autowired // prin Spring, leg Controller-ul de (crearea noii instante de) BookService.
    private BookService bookService;

    //get, post, put, delete, head
    @RequestMapping(method = RequestMethod.POST) // creez 1 book.
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book); // (ma folosesc de userId ca sa stiu cine a creat cartea)
    }

    @RequestMapping(method = RequestMethod.GET) // doar vad books, NU creez nimic.
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Book> getBookByTitleOrAuthor(@RequestParam("title") Optional<String> title, @RequestParam("author") Optional<String> author) {
        return bookService.getBookByTitleOrAuthor(title, author);
    }
}
