package com.lcwd.user.service.external_service;

import com.lcwd.user.service.Entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/user/{userId}")
    List<Rating> get_rating(@PathVariable String userId);

    @PostMapping("/ratings/")
    Rating add_rating(Rating rating);

    @PutMapping("/ratings/{ratingId}")
    Rating update_rating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    void delete_rating(@PathVariable String ratingId);

}
