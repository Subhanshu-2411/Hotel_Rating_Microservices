package com.example.hotel_service.controller;

import com.example.hotel_service.models.Hotel;
import com.example.hotel_service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/get")
    public ResponseEntity<List<Hotel>> getHotels() {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotels());
    }

    @GetMapping("/get/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
    }

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
    }

    @PutMapping("/update/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("hotelId") String hotelId,@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.updateHotel(hotelId, hotel));
    }

    @DeleteMapping("/delete/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") String hotelId) {
        hotelService.deleteHotel(hotelId);
    }

}
