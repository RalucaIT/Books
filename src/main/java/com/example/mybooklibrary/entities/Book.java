package com.example.mybooklibrary.entities;

import javax.persistence.*;
import java.util.List;
// this import includes all 3 Annotations: @Entity, @GeneratedValue, @Id.

@Entity
@Table(name = "books") // now "books" Maps to the actual table name = "books" (plural)
public class Book { // Book is the Main definition point of the relationship == the owner.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "book_id_table")
    private Long book_id_table;

    @Column (name = "book_title")
    private String book_title;

    @Column (name = "book_author")
    private String book_author;

    @ManyToMany
    @JoinTable(
            name = "book_users",
            joinColumns = @JoinColumn(name = "book_users"), // FK
            inverseJoinColumns = @JoinColumn(name = "book_users")) // FK
    private List<User> users; // added a List of associated Users by adding this new attribute.

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Book() {}

    public Long getBook_id_table() {
        return book_id_table;
    }

    public void setBook_id_table(Long book_id_table) {
        this.book_id_table = book_id_table;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }
}
