package com.nanda.demo.spring.boot.controller;

import com.nanda.demo.spring.boot.dao.UserRepository;
import com.nanda.demo.spring.boot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RequestMapping(produces = "application/json", value = "/user")
@RestController
public class UsersController {

    @Inject
    UserRepository userRepository;

    @RequestMapping
    public ResponseEntity<Object> getAllUsers() {

        List<User> users = (List<User>) userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userName}")
    public ResponseEntity<Object> getUserByName(@PathVariable("userName")String userName) {

        User user = userRepository.findByName(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
