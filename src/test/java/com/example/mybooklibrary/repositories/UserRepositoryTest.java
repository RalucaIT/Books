package com.example.mybooklibrary.repositories;

import com.example.mybooklibrary.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired // this brings the object into container
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository.save(user);
    }

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void findAll() {
        List<User> userList = List.of(user);
        List<User>userTestList = userRepository.findAll();
        assertThat(userRepository.findAll()).hasSize(1);
        assertThat(userTestList).isNotNull();
        assertThat(userTestList).usingRecursiveComparison().isEqualTo(userList);
    } // verifica daca field-uri user-ului sunt identice sau nu.
    private static final User user=new User(1L,"Gicu","123456","gicu@gmail.com",null,null);
}