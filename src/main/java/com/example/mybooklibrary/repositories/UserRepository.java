package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> { // this will extend another interface,
    // with Methods: add, find, update, save, delete, etc.
   // <Users = data type, Integer = PK>
     List<User> findAll();


     // List<Book> findByTitleOrAuthor(); book repository
}
