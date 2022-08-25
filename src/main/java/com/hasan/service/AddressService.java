package com.hasan.service;

import com.hasan.entity.Address;
import com.hasan.entity.User;
import com.hasan.repository.AddressRepository;
import com.hasan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


    public Address save(Address address) {

        return addressRepository.save(address);
    }

    public Address getTopByCity(String city) {

        return addressRepository.getTopByCity(city);
    }

    public Address get(Long id) {
        return addressRepository.findTopById(id);
    }

    public Address updateAddress(Address address) {
        Address updateAddress = addressRepository.findTopById(address.getId());
        if (updateAddress != null) {
            updateAddress.setCity(address.getCity());
            return addressRepository.save(updateAddress);
        }
        return null;
    }

    public List<Address> findAll() {

        return addressRepository.findAll();
    }
}
