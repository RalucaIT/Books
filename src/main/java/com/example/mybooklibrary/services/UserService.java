package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getReferenceById(Long user_id_table) {
        return userRepository.getReferenceById(user_id_table);
    }

    public User createUser (User user) {
        return userRepository.saveAndFlush(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteById(Long idUser) {
        userRepository.deleteById(idUser);
    }

    public User saveAndFlush(Long user_id_table, User user) { // automatically created from (UserController)
        User existingUser = userRepository.getReferenceById(user_id_table);
        BeanUtils.copyProperties(user, existingUser, "user_id_table");
        return userRepository.saveAndFlush(existingUser);
    }
}
// cand creez book -> in entities clasa Book -> in controller Clasa BookController -> in service Clasa BookService -> in repository interfata BookRepository extends CrudRepository

