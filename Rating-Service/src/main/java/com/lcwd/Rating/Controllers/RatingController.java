package com.lcwd.Rating.Controllers;

import com.lcwd.Rating.Entities.Rating;
import com.lcwd.Rating.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return new ResponseEntity<>(this.ratingService.create(rating),HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> get_all_ratings(){
        return new ResponseEntity<>(this.ratingService.get_all_rating(),HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> get_user_ratings(@PathVariable String userId){
        return new ResponseEntity<>(this.ratingService.get_ratings_by_user(userId),HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> get_hotel_ratings(@PathVariable String hotelId){
        return new ResponseEntity<>(this.ratingService.get_ratings_for_hotel(hotelId),HttpStatus.OK);
    }
}
