package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.BookOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookOwnerRepository extends JpaRepository<BookOwner, Long> {
    List<BookOwner> findAll();
}

