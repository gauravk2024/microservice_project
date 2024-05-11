package com.thinkitive.microservice.userservice.controller;

import com.thinkitive.microservice.userservice.entity.UserService;
import com.thinkitive.microservice.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UserService> getUser(@PathVariable int id){
        UserService getUser = userService.getUser(id);
        return ResponseEntity.ok().body(getUser);
    }

    @PostMapping("/create")
    public ResponseEntity<UserService> createUser(@RequestBody UserService user){
        UserService createUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserService> updateUserInfo(@PathVariable int id, @RequestBody UserService user){
        UserService updated = userService.updateUser(id, user);
        return ResponseEntity.ok().body(updated);
    }
}