package com.example.rating_service.service;

import com.example.rating_service.models.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    List<Rating> getRatings();

    Rating getRating(String ratingId);

    List<Rating> getUserRating(String userId);

    List<Rating> getHotelRating(String hotelId);

    Rating saveRating(Rating rating);

    Rating updateRating(String ratingId, Rating rating);

    void deleteRating(String ratingId);




}
