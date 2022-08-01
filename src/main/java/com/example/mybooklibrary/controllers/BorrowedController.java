package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.services.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/borrowed")
@RestController
public class BorrowedController {

    @Autowired
    private BorrowedService borrowedService;

    @PostMapping // better use @PostMapping rather than @RequestMapping
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
