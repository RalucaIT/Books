package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.repositories.BookOwnerRepository;
import com.example.mybooklibrary.repositories.BookRepository;
import com.example.mybooklibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookOwnerService {

    @Autowired
    private BookOwnerRepository bookOwnerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

/*    public BookOwner createBookOwner(BookOwner bookOwner) {
        return bookOwnerRepository.saveAndFlush(bookOwner);
    }*/

//    public Book addBookByUser(Book book, Long userId) {
////        if(book == null){
////            System.out.println("Nu era nici o carte");
////            return;
//
//        BookOwner bookOwner = new BookOwner();
//        bookOwnerRepository.save(bookOwner);
//
//        List<Book> books = bookRepository.findAll();
//        if (!books.contains(book)) {
//            bookRepository.save(book);
//        }
//        return book;
//
//    }

    public BookOwner createBookOwner(Long bookId, Long userId) {

//        Optional<Book> bookOptional = bookRepository.findById(bookId);
//        if (bookOptional.isEmpty()) {
//            return null;
//        }

//        Book book = bookOptional.get();

        Book book = bookRepository.findById(bookId).get();

        //Optional<User> userOptional = userRepository.findById(userId);
        //if (userOptional.isEmpty()) {
        //    return null;
        //}

        //User user = userOptional.get();

        User user = userRepository.findById(userId).get();

        BookOwner actualBookOwner = new BookOwner();

        actualBookOwner.setBook(book);
        actualBookOwner.setUser(user);
        return bookOwnerRepository.saveAndFlush(actualBookOwner);
    }
    public List<BookOwner> getBookOwner() {
        return bookOwnerRepository.findAll();
    }
}
