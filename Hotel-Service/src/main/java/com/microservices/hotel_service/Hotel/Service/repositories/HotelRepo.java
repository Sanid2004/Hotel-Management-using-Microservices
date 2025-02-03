package com.microservices.hotel_service.Hotel.Service.repositories;

import com.microservices.hotel_service.Hotel.Service.entities.hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<hotel,String> {

}
