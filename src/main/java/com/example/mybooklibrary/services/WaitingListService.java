package com.example.mybooklibrary.services;

import com.example.mybooklibrary.repositories.BookOwnerRepository;
import com.example.mybooklibrary.repositories.BorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class WaitingListService {
    @Autowired
    private BorrowedRepository borrowedRepository;

    @Autowired
    private BookOwnerRepository bookOwnerRepository;

    }

/**
 *
 */
