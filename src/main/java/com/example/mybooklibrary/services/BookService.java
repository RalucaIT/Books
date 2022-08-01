package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.AvailableBooks;
import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.repositories.AvailableBooksRepository;
import com.example.mybooklibrary.repositories.BookOwnerRepository;
import com.example.mybooklibrary.repositories.BookRepository;
import com.example.mybooklibrary.repositories.BorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookOwnerRepository bookOwnerRepository;

    @Autowired
    private AvailableBooksRepository availableBookRepository;

    @Autowired
    private BorrowedRepository borrowedRepository;

    public Book createBook(Book book) {
        /*
        public Book BookGetsOwner(Integer book_id, Integer user_id) {
    User user = userRepository.findById(user_id).get();
    book.addOwner(user);
    /////////////
    bookOwner.book_id.
    return bookRepository.saveAndFlush(book);
    }
        */
    /*    if (bookRepository.findByTitle(book.getTitle()).isPresent()) {
            return "Book already exists";
            // bookOwner.user_id_table = userId
        } else {
            bookRepository.saveAndFlush(book);
        BookOwner bookOwner = new BookOwner(null, userId, book.getBook_id_table());
        bookOwnerRepository.saveAndFlush(bookOwner);
            AvailableBooks availableBooks = new AvailableBooks(null, bookOwner.getBook_owner_id_table());
            // Borrowed borrowedBook = new Borrowed(null, data, userId, .....)
            // LocalDate.now().plusDays(7) -> o saptamana
            // LocalDate(2022,7,15) + LocalDate.now().plusDays(7);
            availableBookRepository.saveAndFlush(availableBooks);
        }
        return "Book with User created";
    */

        return bookRepository.saveAndFlush(book); // dau carte ca body in Postman si o adauga in tabela Books.
    }   // aceeasi carte poa' sa fie own-uita de useri diferiti.

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBookByTitleOrAuthor(Optional<String> title, Optional<String> author) {
        return bookRepository.findByTitleOrAuthor(title, author);
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
    }
