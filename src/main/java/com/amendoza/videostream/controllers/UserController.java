package com.amendoza.videostream.controllers;

import com.amendoza.videostream.models.User;
import com.amendoza.videostream.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/users/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username){
        return new ResponseEntity<>(service.findByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> findAll(){
        return new ResponseEntity<>(service.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> login(@PathVariable String username, @PathVariable String password){
        return new ResponseEntity<>(service.login(username, password), HttpStatus.OK);
    }


}
