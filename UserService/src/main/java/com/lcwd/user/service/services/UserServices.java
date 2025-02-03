package com.lcwd.user.service.services;

import com.lcwd.user.service.Entities.Rating;
import com.lcwd.user.service.Entities.User;

import java.util.List;

public interface UserServices {
    User save(User user);

    List<User> get_all();

    User get_user(String userId);

    User update(User user);

    User delete(User user);

    Rating addRating(Rating rating);
}
