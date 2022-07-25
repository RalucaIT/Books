package com.example.mybooklibrary.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "borrowed")
public class Borrowed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowed_id_table")
    private Long borrowedIdTable;

    @Column (name = "return_date")
    private LocalDate returnDate;

    @Column (name = "borrowed_date")
    private LocalDate borrowedDate; // 2022-12-30

    @ManyToOne
    @JoinColumn(name = "book_onwer_id_table")
    private BookOwner bookOwner;
    //bookOwner.get_book_owner_id?  // getBookOwnerId

    @ManyToOne
    @JoinColumn(name = "user_id_table")
    private User user;
}
