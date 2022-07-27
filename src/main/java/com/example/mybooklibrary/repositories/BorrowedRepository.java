package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.Book;
import com.example.mybooklibrary.entities.BookOwner;
import com.example.mybooklibrary.entities.Borrowed;
import com.example.mybooklibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {
    List<Borrowed> findAll();
}

