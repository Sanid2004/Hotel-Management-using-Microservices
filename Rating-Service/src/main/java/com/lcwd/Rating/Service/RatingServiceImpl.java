package com.lcwd.Rating.Service;

import com.lcwd.Rating.Entities.Rating;
import com.lcwd.Rating.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        String rating_id = UUID.randomUUID().toString();
        rating.setRatingId(rating_id);
        return this.ratingRepository.save(rating);
    }

    @Override
    public List<Rating> get_all_rating() {
        return this.ratingRepository.findAll();
    }

    @Override
    public List<Rating> get_ratings_by_user(String userId) {
        return this.ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> get_ratings_for_hotel(String hotelId) {
        return this.ratingRepository.findByHotelId(hotelId);
    }
}
