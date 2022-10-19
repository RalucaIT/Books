package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.BookOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookOwnerRepository extends JpaRepository<BookOwner, Long> {
    List<BookOwner> findAll();

    @Query("SELECT bo FROM BookOwner bo \n" +
            "WHERE bo.book.book_id_table = :bookId \n" +
            "AND bo.users.user_id_table = :userId")
    BookOwner checkBookOwnerDuplicate(Long bookId, Long userId);

    @Query("SELECT b FROM BookOwner b " +
            "WHERE b.book.book_id_table = :bookId")
    BookOwner findBookOwnerByBookId(Long bookId);


}

