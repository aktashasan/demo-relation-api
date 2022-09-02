package com.hasan.service;

import com.hasan.entity.Address;
import com.hasan.entity.User;
import com.hasan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressService addressService;

    @Autowired
    private Validator validator;

    public User save(User user) throws Exception {

        List<Address> addressListToSave = new ArrayList<>();

        List<Address> addressList = user.getAddressList();
        if (addressList != null && !addressList.isEmpty()) {
            for (Address item : addressList) {
                Address address = addressService.getTopByCity(item.getCity());
                if (address == null) {
                    addressService.save(item);
                    addressListToSave.add(item);
                } else if (address.getCity() != null) {
                    addressListToSave.add(address);
                }
            }
        }

        if (addressListToSave != null && !addressListToSave.isEmpty()) {
            user.setAddressList(addressListToSave);
        } else {
            throw new Exception("address entity not saved");
        }
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.getTopById(id);
    }

    public boolean deleteById(Long id) {

        userRepository.deleteById(id);
        if (getUserById(id) == null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public User getTopByUsername(String username) {

        return userRepository.getTopByUsername(username);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user, Long id) {

        userRepository.getTopById(id);
        user.setId(id);
        return userRepository.save(user);
    }
}
