package com.teameth.moviebooking.controller;

import com.teameth.moviebooking.jwt.JwtUtil;
import com.teameth.moviebooking.models.AuthenticationRequest;
import com.teameth.moviebooking.models.AuthenticationResponse;
import com.teameth.moviebooking.reservation.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

@Autowired
    AuthenticationManager authenticationManager;
@Autowired
MyUserDetailService userDetailsService;
@Autowired
 private JwtUtil jwtTokenUtil;

    @RequestMapping("/reservations")
    public String getReservation(){
        return "Successfully Signed in!";
    }

    @RequestMapping(value="/authenticate", method= RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username and password",e);
    }final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

          final String jwt = jwtTokenUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
}


}