package com.example.mybooklibrary.controllers;

import com.example.mybooklibrary.entities.AvailableBooks;
import com.example.mybooklibrary.services.AvailableBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/available")
@RequiredArgsConstructor
public class AvailableBooksController {
    private final AvailableBooksService availableBooksService;

    @GetMapping() // doar vad books, NU creez nimic.
    public List<AvailableBooks> getAvailableBooks() {
        return availableBooksService.getAvailableBooks();
    }
}
