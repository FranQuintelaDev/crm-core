package com.crm.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.core.model.User;
import com.crm.core.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(long id) {
        return repository.findById(id).get();
    }

    public String deleteUser(long id) {
        repository.deleteById(id);
        return "user removed !! " + id;
    }

    public User updateUser(User user) {
       return repository.save(user);
    }
    
    public User signUp(User user) {
		return repository.save(user);
    }
    
    public User logIn(User user) {
		return repository.findTop1ByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}