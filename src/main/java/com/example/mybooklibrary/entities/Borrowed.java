package com.example.mybooklibrary.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

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

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private BookOwner bookOwner; // here I bring the PK bookOwnerId from bookOwner table.
    // bookOwner.getBookOwnerId ?

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private User users; // here I bring the PK userId from users table.

}
