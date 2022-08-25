package com.hasan.repository;

import com.hasan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User getTopByAddressId(Long id);

    User getTopByUsername(String username);
}
