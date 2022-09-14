package com.hasan.service;

import com.hasan.entity.Address;
import com.hasan.entity.ERole;
import com.hasan.entity.Role;
import com.hasan.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {

        return roleRepository.save(role);
    }

    public Role findTopByName(ERole name) {

        return roleRepository.findTopByName(name);
    }
}
