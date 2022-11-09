package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.services.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping(path = "/borrowed")
@RestController
public class BorrowedController {

    @Autowired
    private BorrowedService borrowedService;

    // @PostMapping // better use @PostMapping rather than @RequestMapping
    @RequestMapping(method = RequestMethod.POST, path = "/add_borrowed") // creez 1 book.
    public ResponseEntity <Borrowed> createBorrowed(@RequestParam Long bookId,
                                   @RequestParam Long userId,
                                   @RequestParam Integer borrowedWeeks) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/borrowed/add_borrowed").toUriString());
        return ResponseEntity.created(uri).body(borrowedService.createBorrowed(bookId, userId, borrowedWeeks));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/show_borrowed") // doar returnez/vad borrowedBooks, NU creez nimic.
    public ResponseEntity<List<Borrowed>> getBorrowedBooks() {
        List<Borrowed> borrowedBook = borrowedService.getBorrowed();
        return new ResponseEntity<>(borrowedBook, HttpStatus.OK);
    }

    // how many borrowed // localDate.now

    // return borrowed

    //

    // etc.
}
