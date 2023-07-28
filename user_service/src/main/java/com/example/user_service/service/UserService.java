package com.example.user_service.service;

import com.example.user_service.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();

    User getUser(String userId);

    User saveUser(User user);

    User updateUser(String userId, User user);

    void deleteUser(String userId);
}
