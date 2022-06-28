package com.teameth.moviebooking.reservation;

//import com.teameth.moviebooking.service.UserService;
import com.teameth.moviebooking.domain.Role;
import com.teameth.moviebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class MyUserDetailService implements UserDetailsService {
   @Autowired
   private UserService userService;



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       com.teameth.moviebooking.domain.User u1 = userService.getByUsername(userName);
          //List <Role> roles = u1.getRole();
        Set<Role> role = new HashSet<>();
        Role r1 = new Role(1,"ADMIN","ADMIN");
        role.add(r1);
       List<GrantedAuthority> authorities = buildUserAuthority(role);
        return new User(u1.getUsername(), u1.getPassword(),authorities );
    }
    /*private User buildUserForAuthentication(u1,List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }*/
    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // add user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

//}
}

