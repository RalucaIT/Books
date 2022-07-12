package com.example.mybooklibrary.entities;

import lombok.*;

import javax.persistence.*;

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
    @Column(name= "book_owner_id_table")
    private Long book_owner_id_table;

    @JoinColumn(name = "book_id_table")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "user_id_table")
    @ManyToOne
    private User user;

}
