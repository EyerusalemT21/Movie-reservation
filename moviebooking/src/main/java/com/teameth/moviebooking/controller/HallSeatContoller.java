package com.teameth.moviebooking.controller;

import com.teameth.moviebooking.domain.Cinema;
import com.teameth.moviebooking.domain.CinemaHall;
import com.teameth.moviebooking.domain.HallSeat;
import com.teameth.moviebooking.domain.Location;
import com.teameth.moviebooking.service.CinemaHallService;
import com.teameth.moviebooking.service.CinemaService;
import com.teameth.moviebooking.service.HallSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HallSeatContoller {

    @Autowired
    HallSeatService hallSeatService;
    @Autowired
    CinemaHallService cinemaHallService;

    @RequestMapping("/hallseat")
    public List<HallSeat> getAllLocations(){
        return hallSeatService.getAllHallSeat();
    }
    @RequestMapping(method = RequestMethod.POST ,value="/{hall_id}/hallseat")
    public void saveNewHallSeat(@RequestBody HallSeat hallSeat , @PathVariable Integer hall_id){

        CinemaHall cinemaHall = cinemaHallService.getCinemaHall(hall_id);
        hallSeat.setCinemaHall(cinemaHall);
        cinemaHallService.saveCinemaHall(cinemaHall);
    }


}
