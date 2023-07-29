package com.example.hotel_service.service;

import com.example.hotel_service.models.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    List<Hotel> getHotels();

    Hotel getHotel(String hotelId);

    Hotel saveHotel(Hotel hotel);

    Hotel updateHotel(String hotelId, Hotel hotel);

    void deleteHotel(String hotelId);

}
