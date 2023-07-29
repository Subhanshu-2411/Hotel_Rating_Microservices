package com.example.rating_service.service;

import com.example.rating_service.exceptions.ResourceNotFoundException;
import com.example.rating_service.models.Rating;
import com.example.rating_service.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImplementation implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRating(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"+ ratingId));
    }

    @Override
    public List<Rating> getUserRating(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getHotelRating(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(String ratingId, Rating rating) {
        rating.setRatingId(ratingId);
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(String ratingId) {
        ratingRepository.deleteById(ratingId);
    }
}
