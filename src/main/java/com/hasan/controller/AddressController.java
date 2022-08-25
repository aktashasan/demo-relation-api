package com.hasan.controller;

import com.hasan.entity.Address;
import com.hasan.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Address> get(@PathVariable(value = "id")Long id){

        Address address = addressService.get(id);
        return ResponseEntity.ok(address);
    }
    @PostMapping("/update")
    public ResponseEntity<Address> get(@RequestBody Address address){

        return ResponseEntity.ok(addressService.updateAddress(address));
    }



    @GetMapping("/findAll")
    public List<Address> findAll(){
        return addressService.findAll();
    }

}
