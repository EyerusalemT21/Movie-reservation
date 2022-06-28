
package com.teameth.moviebooking.service;

import com.teameth.moviebooking.domain.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private com.teameth.moviebooking.repository.RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public void saveNewRole(Role role){
        roleRepository.save(role);
    }
}

