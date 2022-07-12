package com.example.mybooklibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// this import includes all 3 Annotations: @Entity, @GeneratedValue, @Id.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "books") // now "books" Maps to the actual table name = "books" (plural)
public class Book { // Book is the Main definition point of the relationship == the owner.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "book_id_table")
    private Long book_id_table;

    @Column (name = "title")
    private String title;

    @Column (name = "author")
    private String author;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private List<BookOwner> bookOwnerList;

    public Book(Long book_id_table) {
        this.book_id_table = book_id_table;
    }
}
