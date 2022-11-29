package com.crm.core.repository;


import org.springframework.stereotype.Repository;

import com.crm.core.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    

    public List<User> createUsers() {
        return List.of(
                new User(1, "Ford employee", "samplepass"),
                new User(2, "admin", "admin"),
                new User(3, "user", "user")
        );
    }
    
    private List<User> list = new ArrayList<User>(createUsers());

    public List<User> getAllUsers() {
        return list;
    }

    public User findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<User> search(String username) {
        return list.stream().filter(x -> x.getUsername().startsWith(username)).collect(Collectors.toList());
    }

    public User save(User u) {
        User user = new User();
        user.setId(u.getId());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        list.add(user);
        return user;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public User update(User u) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (u.getId())) {
                id = u.getId();
                idx = i;
                break;
            }
        }

        User user = new User();
        user.setId(id);
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        list.set(idx, u);
        return user;
    }
}