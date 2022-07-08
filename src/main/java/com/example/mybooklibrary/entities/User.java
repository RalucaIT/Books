package com.example.mybooklibrary.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User { // actually, it will be only 1 single instance/row of this Users data.
    @Id // is the PK = primary key field.
    @GeneratedValue (strategy = GenerationType.IDENTITY) // specifies how the PK gets populated on a new record insert.
    // with IDENTITY, JPA will use the Postgresql created sequence for PK value
    @Column (name = "user_id_table")
    private Long user_id_table;

    @Column (name = "user_name")
    private String user_name;

    @Column (name = "user_password")
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String user_password;

    @Column (name = "user_email")
    @NotNull
    private String user_email;

    @ManyToMany(mappedBy = "users")
    private List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User() {}

        public List<Book> getBooks() {
            return books;
        }

    public Long getUser_id_table() {
        return user_id_table;
    }

    public void setUser_id_table(Long user_id_table) {
        this.user_id_table = user_id_table;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() { // get_password, then set_password.
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}


