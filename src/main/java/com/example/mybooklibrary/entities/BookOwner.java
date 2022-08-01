package com.example.mybooklibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @JoinColumn(name = "user_id_table")
    @ManyToOne
    private User user;
    /*
    @JsonIgnore
    @OneToMany(mappedBy = "bookOwner")
    private List<Borrowed> borrowed;
    bookOwner.getUser().getBorrowedList(); // BETTER
    bookOwner.getBorrowed(); // not ok
    */

    @JsonIgnore
    @OneToMany(mappedBy = "bookOwner")
    private List<AvailableBooks> availableBooksList;

}