package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();
    List<Book> findByTitleOrAuthor(Optional<String> title, Optional<String> author);


}
