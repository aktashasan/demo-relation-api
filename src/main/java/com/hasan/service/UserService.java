package com.hasan.service;

import com.hasan.entity.Address;
import com.hasan.entity.User;
import com.hasan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressService addressService;

    @Autowired
    private Validator validator;

    public User save(User user) throws Exception {
//        Set<ConstraintViolation<Object>> violations = validator.validate(user);
//        if (!violations.isEmpty()) {
//            String errors = "";
//            for (ConstraintViolation<Object> violation : violations) {
//                errors += violation.getPropertyPath() + "-" + violation.getMessage();
//            }
//            throw new Exception(errors);
//        }

        List<Address> addressListToSave = new ArrayList<>();

        List<Address> addressList = user.getAddress();
        if (addressList != null && !addressList.isEmpty()) {
            for (Address item : addressList) {
                Address address = addressService.getTopByCity(item.getCity());
                if (address == null) {
                    addressService.save(item);
                    addressListToSave.add(item);
                }
                else if (address.getCity() != null) {
                    addressListToSave.add(address);
                }
            }
        }

        if (addressListToSave != null && !addressListToSave.isEmpty()) {
            user.setAddress(addressListToSave);
        } else {
            throw new Exception("address entity not saved");
        }
        return userRepository.save(user);
    }

    public User get(String username) {

        return userRepository.getTopByUsername(username);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

//    public void save(List<User> userData) {
//    }
}
