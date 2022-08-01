package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.repositories.BookOwnerRepository;
import com.example.mybooklibrary.repositories.BorrowedRepository;
import com.example.mybooklibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowedService {
    @Autowired
    private BorrowedRepository borrowedRepository;

    @Autowired
    private BookOwnerRepository bookOwnerRepository;
    @Autowired
    private UserRepository userRepository;
    private Borrowed borrowedId;

    public Borrowed createBorrowed(Long bookOwnerId, Long userId,Integer borrowedWeeks) {

         BookOwner bookOwner = bookOwnerRepository.findById(bookOwnerId).get();

         User user = userRepository.findById(userId).get();

         Borrowed actualBorrowed = new Borrowed();

        actualBorrowed.setUser(user);
        actualBorrowed.setBookOwner(bookOwner);
        actualBorrowed.setBorrowedDate(LocalDate.now());
        actualBorrowed.setReturnDate(LocalDate.now().plusWeeks(borrowedWeeks));
        return borrowedRepository.saveAndFlush(actualBorrowed);
    }

    public List<Borrowed> getBorrowed() {
        return borrowedRepository.findAll();
    }
}
// here I write de IDs which I want to wire with the borrowed Books.



