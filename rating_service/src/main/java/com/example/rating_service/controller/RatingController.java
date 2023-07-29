package com.example.rating_service.controller;

import com.example.rating_service.models.Rating;
import com.example.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/get")
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
    }

    @GetMapping("/get/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable("ratingId") String ratingId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRating(ratingId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getUserRating(@PathVariable("userId") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getUserRating(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getHotelRating(@PathVariable("hotelId") String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getHotelRating(hotelId));
    }

    @PostMapping("/save")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    @PutMapping("/update/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, @RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.updateRating(ratingId, rating));
    }

    @DeleteMapping("/delete/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId) {
        ratingService.deleteRating(ratingId);
    }

}
