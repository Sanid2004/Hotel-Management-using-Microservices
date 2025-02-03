package com.lcwd.user.service.Repository;

import com.lcwd.user.service.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,String> {

}
