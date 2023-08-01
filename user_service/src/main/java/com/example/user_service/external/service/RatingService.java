package com.example.user_service.external.service;

import com.example.user_service.models.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@FeignClient("RATING-SERVICE")
public interface RatingService {

    @GetMapping("rating/user/{userId}")
    ResponseEntity<ArrayList<Rating>> getUserRatings(@PathVariable("userId") String userId);
}
