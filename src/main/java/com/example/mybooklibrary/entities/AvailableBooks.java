package com.example.mybooklibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AvailableBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "availableBookId")
    private Long availableBookId;

    @JoinColumn(name = "book_owner_id_table")
    @ManyToOne
    private BookOwner bookOwner;

    public AvailableBooks(Long availableBookId, Long bookOwnerIdTable) {
        this.availableBookId = availableBookId;
        this.bookOwner = new BookOwner(bookOwnerIdTable);
    }
}
