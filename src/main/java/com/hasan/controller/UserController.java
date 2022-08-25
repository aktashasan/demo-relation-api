package com.hasan.controller;

import com.hasan.entity.Address;
import com.hasan.entity.User;
import com.hasan.repository.UserRepository;
import com.hasan.service.AddressService;
import com.hasan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User userData){


        try {
            userService.save(userData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Data saved");
    }

    @GetMapping("/get/{username}")
    public User get(@PathVariable(value = "username") String username){

        return userService.get(username);
    }

    @GetMapping("/findAll")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

}
