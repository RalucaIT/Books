package com.example.mybooklibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
// adnotari pt get & set
@NoArgsConstructor
@AllArgsConstructor
//
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
    @NonNull
    private String user_password;

    @Column (name = "user_email")
    @NonNull
    private String user_email;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<BookOwner> bookOwnerList;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Borrowed> borrowedList;

    public User(Long userId) {
        this.user_id_table = userId;
    }
}


