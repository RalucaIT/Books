package com.example.mybooklibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @Data // in loc de Getter, Setter and AllArgs, but no "No Args".
@Entity
@Table(name = "books_owner")
public class BookOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_owner_id_table")
    private Long book_owner_id_table;

    @JoinColumn(name = "book_id_table")
    @ManyToOne
    private Book book;

    //user id
    private Long userId;

    @JoinColumn(name = "user_id_table")
    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "bookOwner")
    private List<Borrowed> borrowed;

    @JsonIgnore
    @OneToMany(mappedBy = "bookOwner")
    private List<AvailableBooks> availableBooksList;

    public BookOwner(Long book_owner_id_table, Long userId, Long book_id_table) {
        this.book_owner_id_table = book_owner_id_table;
        this.user = new User(userId);
        this.book = new Book(book_id_table);
    }

    public BookOwner(Book book, Long ownerId) {
        this.book = book;
        this.userId = ownerId;
    }

    public BookOwner(Long book_owner_id_table) {
        this.book_owner_id_table = book_owner_id_table;
    }
}


