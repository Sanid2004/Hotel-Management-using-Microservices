package com.lcwd.user.service.external_service;

import com.lcwd.user.service.Entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/hotel/{hotel_id}")
    Hotel get_hotel(@PathVariable String hotel_id);

}
