package com.hasan.controller;

import com.hasan.entity.User;
import com.hasan.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "This is to add  the User in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = " Address details saved in database",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = " Page Not Found",
                    content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody User userData){


        try {
            userService.save(userData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Data saved");
    }
    @Operation(summary = "This is to get  the details of particular  User in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = " Address details fetched from database",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = " Page Not Found",
                    content = @Content)
    })
    @GetMapping("/get/{username}")
    public User getByUsername(@PathVariable(value = "username") String username){

        return userService.getTopByUsername(username);
    }

//    @Operation(summary = "This is to delete of particular  User in the database")
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Boolean> deleteById(@PathVariable long id)
//    {
//
//        return ResponseEntity.ok(userService.deleteById(id));
//    }

    @Operation(summary = "This is to delete of particular  User in the database")
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id)
    {

        return ResponseEntity.ok(userService.deleteById(id));
    }
    @Operation(summary = "This is to update of particular  User in the database")
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable(value = "id") Long id){

        return ResponseEntity.ok(userService.updateUser(user,id));
    }

    @Operation(summary = "This is to fetch All the User stored in Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Details of All the Address",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Page not found",
                    content = @Content)
    })
    @GetMapping("/findAll")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

}
