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
@AllArgsConstructor// now "books" Maps to the actual table name = "books" (plural)
public class BookDto { // Book is the Main definition point of the relationship == the owner.

    private String title;

    private String author;

    private List<BookOwner> bookOwnerList;
}
// a different class, like studentMapper