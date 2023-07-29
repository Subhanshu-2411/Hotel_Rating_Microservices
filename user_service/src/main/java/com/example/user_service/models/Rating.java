package com.example.user_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private Integer rating;
    private String feedback;

}
