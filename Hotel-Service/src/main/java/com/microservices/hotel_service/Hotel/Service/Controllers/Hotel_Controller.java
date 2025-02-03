package com.microservices.hotel_service.Hotel.Service.Controllers;

import com.microservices.hotel_service.Hotel.Service.Services.HotelService;
import com.microservices.hotel_service.Hotel.Service.entities.hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class Hotel_Controller {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/")
    public ResponseEntity<hotel> create_hotel(@RequestBody hotel hotel1){
        hotel hotel = this.hotelService.create_hotel(hotel1);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<hotel>> get_all(){
        return new ResponseEntity<>(this.hotelService.get_all(),HttpStatus.OK);
    }

    @GetMapping("/{hotel_id}")
    public ResponseEntity<hotel> get_hotel(@PathVariable String hotel_id){
        return new ResponseEntity<>(this.hotelService.get_hotel(hotel_id),HttpStatus.OK);
    }
}
