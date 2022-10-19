package com.example.mybooklibrary.services;

import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.exceptions.ResourceNotFoundException;
import com.example.mybooklibrary.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User getReferenceById(Long user_id_table) {
        User user=userRepository.getReferenceById(user_id_table);
        if(user==null){
            throw new ResourceNotFoundException("User with id "+user_id_table+" not found");
        }
        return user;
    }

    public User createUser (User user) {
         user.setUser_password(passwordEncoder.encode(user.getUser_password()));
      //  System.out.println(user.getUser_password());
        return userRepository.saveAndFlush(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUser (Long user_id_table, User user) { // automatically created from (UserController)
        User user1 =userRepository.findById(user_id_table).orElseThrow(()->new ResourceNotFoundException("User with id "
                +user_id_table+" not found"));
        BeanUtils.copyProperties(user, user1 , "user_id_table");
        return userRepository.saveAndFlush(user1); // updates the preName/pssw/mail/userId into the new ones
    }

    public String  deleteById(Long idUser) {
        User user =userRepository.findById(idUser).orElseThrow(()->new ResourceNotFoundException("User with id "
                +idUser+" not found"));
        userRepository.deleteById(idUser);
        return  "User with id "+ idUser +" was deleted";
    }
}
// cand creez book -> in entities clasa Book -> in controller Clasa BookController -> in service Clasa BookService -> in repository interfata BookRepository extends JPA/CrudRepository

