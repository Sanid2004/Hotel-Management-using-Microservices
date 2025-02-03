package com.microservices.hotel_service.Hotel.Service.Services;

import com.microservices.hotel_service.Hotel.Service.Exceptions.ResourceNotFoundException;
import com.microservices.hotel_service.Hotel.Service.entities.hotel;
import com.microservices.hotel_service.Hotel.Service.repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public hotel create_hotel(hotel hotel1) {
        String hotel_id = UUID.randomUUID().toString();
        hotel1.setId(hotel_id);
        return this.hotelRepo.save(hotel1);
    }

    @Override
    public List<hotel> get_all() {
        return this.hotelRepo.findAll();
    }

    @Override
    public hotel get_hotel(String hotel_id) {
        return this.hotelRepo.findById(hotel_id).orElseThrow(()->new ResourceNotFoundException("The given id not found !!"));
    }
}
