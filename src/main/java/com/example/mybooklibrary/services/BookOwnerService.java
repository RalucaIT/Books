package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.repositories.BookOwnerRepository;
import com.example.mybooklibrary.repositories.BookRepository;
import com.example.mybooklibrary.repositories.BorrowedRepository;
import com.example.mybooklibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookOwnerService {

    @Autowired
    private BookOwnerRepository bookOwnerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowedRepository borrowedRepository;

 /*    public BookOwner createBookOwner(BookOwner bookOwner) {
        return bookOwnerRepository.saveAndFlush(bookOwner);
}
 */
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
        BookOwner checkBookOwner = bookOwnerRepository.checkBookOwnerDuplicate(bookId,userId);
        if(checkBookOwner == null) {
            actualBookOwner.setBook(book);
            actualBookOwner.setUsers(user);
            return bookOwnerRepository.saveAndFlush(actualBookOwner);
        }
        return null;
    }

    public List<BookOwner> getBookOwner() {
        return bookOwnerRepository.findAll();
    }

    public List<Book> getAvailableBooks() {
        List<Book> book = bookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for (Book b : book) {
            Borrowed borrowed = borrowedRepository.getBorrowedByBookOwner_Book(b);
            if (borrowed == null) {
                books.add(b);
            }
        }
        return books;
    }



//    SELECT COUNT(borrowedBookOwnerId).FROM borrowed WHERE borrowedBookOwnerId = "id";
//
//    SELECT bookOwnerId FROM booksOwner WHERE bo.bookIs = "bookIdTable"; // bo == alias
//
//    SELECT bookId FROM books b WHERE b.title = "title";

}
