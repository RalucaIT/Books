package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.repositories.BookOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class BookOwnerService {

    @Autowired
    private BookOwnerRepository bookOwnerRepository;

    public void createBookOwner(BookOwner bookOwner) {
    }

    public List<BookOwner> getBookOwner() {

        return bookOwnerRepository.findAll();
    }
}
