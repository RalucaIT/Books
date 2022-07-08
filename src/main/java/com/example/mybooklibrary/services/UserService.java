package com.example.mybooklibrary.services;


import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getReferenceById(Integer user_id_table) {
        return userRepository.getReferenceById(user_id_table);
    }

    public User createUser (User user) {
        return userRepository.save(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteById(Integer idUser) {
        userRepository.deleteById(idUser);
    }

    public User saveAndFlush(User existingUser) { // automatically created from (UserController)
        return userRepository.saveAndFlush(existingUser);
    }
}
// cand creez book -> in entities clasa Book -> in controller Clasa BookController -> in service Clasa BookService -> in repository interfata BookRepository extends CrudRepository

