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
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean deleteUser(long userId){
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }


    public boolean updateUserName(long userId, String name) {
        if(userRepository.existsById(userId)) {
            userRepository.findById(userId).get().setName(name);
            return true;
        }
        return false;
    }
}
