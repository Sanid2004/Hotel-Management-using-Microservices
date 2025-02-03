package com.lcwd.Rating.Service;

import com.lcwd.Rating.Entities.Rating;

import java.util.List;

public interface RatingService {
    // create
    Rating create(Rating rating);

    //get all ratings
    List<Rating> get_all_rating();

    //get ratings by user
    List<Rating> get_ratings_by_user(String userId);

    // get ratings for a hotel
    List<Rating> get_ratings_for_hotel(String hotelId);
}
