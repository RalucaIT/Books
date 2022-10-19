package com.example.mybooklibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private Long bookOwnerIdTable;


    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "book_id_table")
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private Book book;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id_table")
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private User users;


    /*
    @JsonIgnore
    @OneToMany(mappedBy = "bookOwner")
    private List<Borrowed> borrowed;
    bookOwner.getUser().getBorrowedList(); // BETTER
    bookOwner.getBorrowed(); // not ok
    */


}