package com.example.apiDemo.service;

import com.example.apiDemo.User;
import com.example.apiDemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private List<User> users = new ArrayList<>();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public String deleteUser(Long userId){
        if(users.stream().anyMatch(user -> user.getId().equals(userId))) {
            users.removeIf(user -> user.getId().equals(userId));
            return "User deleted";
        }
        return "User not found";
    }


}
