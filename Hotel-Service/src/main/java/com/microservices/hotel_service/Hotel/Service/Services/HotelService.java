package com.microservices.hotel_service.Hotel.Service.Services;

import com.microservices.hotel_service.Hotel.Service.entities.hotel;

import java.util.List;

public interface HotelService {
    hotel create_hotel(hotel hotel1);

    List<hotel> get_all();

    hotel get_hotel(String hotel_id);

}
