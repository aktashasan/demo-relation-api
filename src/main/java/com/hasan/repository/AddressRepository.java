package com.hasan.repository;

import com.hasan.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address getTopByCity(String city);

    Address findTopById(Long id);
//    Address findTopByAddress(Address address);
}
