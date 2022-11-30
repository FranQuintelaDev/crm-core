package com.crm.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.core.model.User;
import com.crm.core.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/api/v1/users")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping("/api/v1/users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/api/v1/users/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PutMapping("/api/v1/users/{id}")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
    
    @PostMapping("/api/v1/auth/signUp")
    public User signUp(@RequestBody User user) {
        return service.signUp(user);
    }
    
    @PostMapping("/api/v1/auth/logIn")
    public User logIn(@RequestBody User user) {
        return service.logIn(user);
    }
    
}