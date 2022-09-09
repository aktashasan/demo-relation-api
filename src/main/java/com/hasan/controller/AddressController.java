package com.hasan.controller;

import com.hasan.entity.Address;
import com.hasan.service.AddressService;
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
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

//    @Operation(summary = "This is to add  the Address in the database. just use only userService. ")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200",
//                    description = " Address details saved in database",
//                    content = {@Content(mediaType = "application/json")}),
//            @ApiResponse(responseCode = "404",
//                    description = " Page Not Found",
//                    content = @Content)
//    })
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/save")
//    public Address save(@RequestBody Address address) {
//        return addressService.save(address);
//    }

    @Operation(summary = "This is to get  the details of particular  Address in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = " Address details fetched from database",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = " Page Not Found",
                    content = @Content)
    })
    @GetMapping("/get/{id}")
    public ResponseEntity<Address> getById(@PathVariable(value = "id") Long id) {

        Address address = addressService.get(id);
        return ResponseEntity.ok(address);
    }

    @Operation(summary = "This is to update of particular  Address in the database")
    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateById(@RequestBody Address address, @PathVariable(value = "id") Long id) {

        return ResponseEntity.ok(addressService.updateAddress(address, id));
    }


    @Operation(summary = "This is to fetch All the Address stored in Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Details of All the Address",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Page not found",
                    content = @Content)
    })
    @GetMapping("/get/findAll")
    public List<Address> findAll() {
        return addressService.findAll();
    }

}
