package com.example.mybooklibrary.repositories;
import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BorrowedRepositoryTest {

    @Autowired
    private BorrowedRepository borrowedRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.save(user);
        bookRepository.save(book);
        borrowedRepository.save(borrowed);
        //bookOwnerRepository.save(new BookOwner());
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        bookRepository.deleteAll();
        borrowedRepository.deleteAll();
    }

    @Test
    void getBorrowedBookByOthers() {
        List<Borrowed> borrowedList = borrowedRepository.getBorrowedBookByOthers(1);
        assertThat(borrowedList).isNotNull();
    }
//
//    @Test
//    void getBorrowedByAccount_id() {
//    }
//
//    @Test
//    void getTitleOrAuthor() {
//    }
//
//    @Test
//    void getBorrowedByBookOwner_Book() {
//    }

    private static final User user = User.builder().user_name("Teo").user_email("teo@gmail.com").user_password("4444").build();
    private static final Book book = Book.builder().title("Book").build();
    private static  final BookOwner bookOwner=new BookOwner(book,user);
    private static final Borrowed borrowed = Borrowed.builder().bookOwner(bookOwner).borrowedIdTable(1l).build();
}
