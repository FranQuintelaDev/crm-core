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
        return repository.getAllUsers();
    }

    public User getUserById(int id) {
        return repository.findById(id);
    }

    public String deleteUser(int id) {
        repository.delete(id);
        return "user removed !! " + id;
    }

    public User updateUser(User user) {
       return repository.update(user);
    }
    
    public User signUp(User user) {
		return repository.save(user);
    }
    
    public User logIn(User user) {
    	User search = repository.search(user.getUsername()).stream().filter(x -> x.getPassword().equals(user.getPassword())).findFirst().get();
		return search;
    }
}