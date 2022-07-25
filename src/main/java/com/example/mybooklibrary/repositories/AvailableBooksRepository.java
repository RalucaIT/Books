package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.AvailableBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AvailableBooksRepository extends JpaRepository <AvailableBooks, Long> {

    List<AvailableBooks> findAll();
}
