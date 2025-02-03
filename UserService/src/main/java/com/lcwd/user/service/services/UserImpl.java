package com.lcwd.user.service.services;

import com.lcwd.user.service.Entities.Hotel;
import com.lcwd.user.service.Entities.Rating;
import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.Exceptions.ResourceNotFoundException;
import com.lcwd.user.service.Repository.UserRepo;
import com.lcwd.user.service.external_service.HotelService;
import com.lcwd.user.service.external_service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    private Logger logger =  LoggerFactory.getLogger(UserImpl.class);

    @Override
    public User save(User user) {
        // generate unique userID
        String random_UserId = UUID.randomUUID().toString();
        user.setUserId(random_UserId);
        return this.userRepo.save(user);
    }

    @Override
    public List<User> get_all() {
        List<User> list = this.userRepo.findAll();
        List<User> list2 = list.stream().map(user -> {
            List<Rating> ratings = ratingService.get_rating(user.getUserId());
            List<Rating> ratings1 = ratings.stream().map(rating -> {
                Hotel hotel = hotelService.get_hotel(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;
            }).toList();
            user.setRatings(ratings1);

            return user;
        }).toList();

        return list2;
    }

    @Override
    public User get_user(String userId) {
        User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with id "+userId+" not found on server !"));

        // Now to get the rating values , we need to make a http request to that microservice.
        // This can be done using RestTemplate or Feing Client . Each one has it's advantages and disadvantages
        // http://localhost:8083/ratings/user/9ae15f59-52d0-48b9-820f-eafaf6c62ccf
        Rating[] UserRatings = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(), Rating[].class);
        logger.info("{}",UserRatings);
        List<Rating> ratings =  Arrays.stream(UserRatings).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
//            // api call to hotel service to get hotel
              // http://localhost:8082/hotel/ac33f9f7-562f-40ea-9dc7-0afb69d8000d
            // But here we shall use Feign client instead of RestTemplate
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(),Hotel.class);

            //logger.info("response code : {} ",forEntity.getStatusCode());
            Hotel hotel = hotelService.get_hotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User update(User user) {
        User user1 = this.userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("User with id "+user.getUserId()+" not found on server !"));
        user1.setUserId(user.getUserId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAbout(user.getAbout());
        user1 = this.userRepo.save(user1);
        return user1;
    }

    @Override
    public User delete(User user) {
         this.userRepo.delete(user);
         return user;
    }

    @Override
    public Rating addRating(Rating rating) {
        return this.ratingService.add_rating(rating);
    }

}
