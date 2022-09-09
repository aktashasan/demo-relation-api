package com.hasan.repository;

import com.hasan.entity.ERole;
import com.hasan.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findTopByName(ERole name);

    Optional<Role> findByName(ERole roleUser);
}
