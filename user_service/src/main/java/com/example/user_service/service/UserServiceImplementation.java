package com.example.user_service.service;

import com.example.user_service.exceptions.ResourceNotFoundException;
import com.example.user_service.models.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found: " + userId));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String userId, User user) {
        user.setUserId(userId);
        return userRepository.save(user);

    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
