package com.hasan.controller;

import com.hasan.entity.Address;
import com.hasan.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/save")
    public Address save(){
        Address address = new Address();
        return addressService.save(address);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Address> get(@PathVariable(value = "id")Long id){

        Address address = addressService.get(id);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/findAll")
    public List<Address> findAll(){
        return addressService.findAll();
    }

}
