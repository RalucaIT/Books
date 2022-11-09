package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.User;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository.save(user);
        bookRepository.save(book);
    }
    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
        bookRepository.deleteAll();
    }

    @Test
    void findByTitleOrAuthor() {
    List<Book> testBookList = bookRepository.findBookByTitleOrAuthor("Hello, book!", "Jack Mack");
     assertThat(testBookList).isNotNull();
     assertThat(testBookList).isInstanceOf(List.class);
    }

private static final User user = User.builder().user_id_table(1l).user_email("ralu@gmail.com").user_name("ralu").user_password("9876poiu").bookOwnerList(null).borrowedList(null).build();
private static final Book book = Book.builder().book_id_table(1l).title("Hello, book!").author("Jack Mack").bookOwnerList(null).build();
}

// ctrl + Shift + T = creates an automated Test Class for each one of the Classes in: repos, controllers and services.