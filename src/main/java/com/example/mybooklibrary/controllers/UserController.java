package com.example.mybooklibrary.controllers; // Controllers will handle our API endpoints
// && Controllers will gonna be REST-API based.

import com.example.mybooklibrary.entities.User;
import com.example.mybooklibrary.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // these annotations help Spring MVC (Model-View-Controller) knows that these are Controllers.
// respond to payloads incoming & outgoing as JSON REST endpoints.
// A controller updates both models and views. It accepts input and performs the corresponding update.
// For example, a controller can update a model by changing the attributes of a character in a video game.
// It may modify the view by displaying the updated character in the game.
@RequestMapping("/users") // my path (deci ii dau ruta specific, NU local host)
// tells the Router what the Mapping URL will look like.
// so all requests written on that (Postman) URL, will pe sent to this UserController.
public class UserController {
    @Autowired // prin Spring, leg Controller-ul de (crearea noii instante de) UserService.
    private UserService userService;

    // (head) list, get, create, delete, put /post
    @RequestMapping(method = RequestMethod.POST, path = "/add_user") // creez 1 user.
    public ResponseEntity<User> createUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/add_user").toUriString());
        return ResponseEntity.created(uri).body(userService.createUser(user));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/show_users") // doar returnez/vad userii, NU creez nimic.
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList=userService.getUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "{user_id_table}", method = RequestMethod.PUT) // editez 1 user.
    public ResponseEntity<User> update(@PathVariable Long user_id_table, @RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{user_id_table}").toUriString());
        return ResponseEntity.created(uri).body(userService.updateUser(user_id_table,user));
    }

    @RequestMapping(value = "{user_id_table}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long user_id_table) {
    String message= userService.deleteById(user_id_table);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{user_id_table}").toUriString());
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }
}

