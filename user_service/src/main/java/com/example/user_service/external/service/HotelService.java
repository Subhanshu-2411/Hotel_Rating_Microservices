package com.example.user_service.external.service;

import com.example.user_service.models.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("hotel/{hotelId}")
    ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId);

}
