package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {
    List<Borrowed> findAll();
}
