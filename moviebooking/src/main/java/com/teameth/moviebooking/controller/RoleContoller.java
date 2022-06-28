
package com.teameth.moviebooking.controller;

import com.teameth.moviebooking.domain.Role;
import com.teameth.moviebooking.domain.User;
import com.teameth.moviebooking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RoleContoller {

    @Autowired

    RoleService roleService;

    @RequestMapping("/role/{roleName}")
    public Role getAllLocations(@PathVariable String roleName){
        return roleService.findByName(roleName);
    }

    @RequestMapping(method = RequestMethod.POST ,value="/role")
    public void saveNewLocation(@RequestBody Role role){
        roleService.saveNewRole(role);
    }





}

