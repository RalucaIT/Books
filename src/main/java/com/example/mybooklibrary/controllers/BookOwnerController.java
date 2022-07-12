package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.services.BookOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@RequestMapping("/api/bookOwner")
public class BookOwnerController {
    @Autowired // prin Spring, leg Controller-ul de (crearea noii instante de) bookOwnerService.
    private BookOwnerService bookOwnerService;

    //get, post, put, delete, head
    @RequestMapping(method = RequestMethod.POST)
    public void createBookOwner(@RequestBody BookOwner bookOwner) {
        bookOwnerService.createBookOwner(bookOwner);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookOwner> getBookOwner() {
        return bookOwnerService.getBookOwner();
    }
}
