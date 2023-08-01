package com.example.user_service.service;

import com.example.user_service.exceptions.ResourceNotFoundException;
import com.example.user_service.external.service.HotelService;
import com.example.user_service.models.Hotel;
import com.example.user_service.models.Rating;
import com.example.user_service.models.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.http.RestTemplateEurekaHttpClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;


    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        for(User user: users) {
            user.setRatings(restTemplate.getForObject("http://localhost:8003/rating/user/" + user.getUserId(), ArrayList.class));
        }
        return users;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found: " + userId));
//        user.setRatings(restTemplate.getForObject("http://localhost:8003/rating/user/" + user.getUserId(), ArrayList.class).stream().map(rating -> {
//            rating.setHotel(restTemplate.getForObject("http://localhost:8002/hotel/get/" + rating.getHotelId(), Hotel.class));
//        }).collect(Collectors.toList()));
        ArrayList<Rating> ratings = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserId(), ArrayList.class);
        ratings.stream().map(rating -> {
            rating.setHotel(hotelService.getHotel(rating.getHotelId()).getBody());
            return rating;
        });
        user.setRatings(ratings);
        return user;
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
