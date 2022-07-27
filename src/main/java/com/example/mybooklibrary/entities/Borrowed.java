package com.example.mybooklibrary.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "borrowed")
public class Borrowed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowed_id_table")
    private Long borrowedIdTable;

    @Column (name = "borrowed_date")
    private LocalDate borrowedDate; // 2022-12-30

    @Column (name = "return_date")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "book_onwer_id_table")
    private BookOwner bookOwner; // here I bring the PK bookOwnerId from bookOwner table.
    // bookOwner.getBookOwnerId ?

    @ManyToOne
    @JoinColumn(name = "user_id_table")
    private User user; // here I bring the PK userId from users table.

}
