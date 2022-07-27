package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.services.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping(path = "/borrowed")
@RestController
public class BorrowedController {

    @Autowired
    private BorrowedService borrowedService;

    @RequestMapping(method = RequestMethod.POST)
    public Borrowed createBorrowed(@RequestParam Long bookOwnerId,
                                   @RequestParam Long userId,
                                   @RequestParam Integer borrowedWeeks) {
        return borrowedService.createBorrowed(bookOwnerId, userId, borrowedWeeks);
    }


    // how many borrowed // localDate.now

    // return borrowed

    //

    // etc.
}
