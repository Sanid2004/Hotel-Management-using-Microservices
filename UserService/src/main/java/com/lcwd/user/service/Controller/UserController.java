package com.lcwd.user.service.Controller;
import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/")
    public ResponseEntity<User> create_user(@RequestBody User user){
        User user1 = this.userServices.save(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> get_user(@PathVariable String userid){
        User user = this.userServices.get_user(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> get_all_users(){
        List<User> list = this.userServices.get_all();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<User> update_user(@RequestBody User user){
        User user1 = this.userServices.update(user);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<User> delete_user(@RequestBody User user){
        User user1= this.userServices.delete(user);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }
}