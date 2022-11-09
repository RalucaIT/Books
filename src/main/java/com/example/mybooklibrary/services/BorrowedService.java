package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.exceptions.ResourceNotFoundException;
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

    public Borrowed createBorrowed(Long bookId, Long userId, Integer borrowedWeeks) {

         BookOwner bookOwner = bookOwnerRepository.findBookOwnerByBookId(bookId);
       // User user1 =userRepository.findById(user_id_table).orElseThrow(()->new ResourceNotFoundException("User with id "
             //   +user_id_table+" not found"));
         User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with Id"+ userId +"not found"));

         Borrowed actualBorrowed = new Borrowed();

        actualBorrowed.setUsers(user);
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



