package com.teameth.moviebooking.controller;

import com.teameth.moviebooking.domain.Cinema;
import com.teameth.moviebooking.domain.CinemaHall;
import com.teameth.moviebooking.domain.Location;
import com.teameth.moviebooking.service.CinemaHallService;
import com.teameth.moviebooking.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaHallController {
    @Autowired
    private CinemaHallService cinemaHallService;

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping("/cinemaHall")
    public List<CinemaHall> getAllCinemaHalls(){
        return cinemaHallService.getAllCinemaHall();
    }

   @RequestMapping(method = RequestMethod.POST ,value="/{cinemaid}/cinemaHall")
    public void saveNewCinemaHall(@RequestBody CinemaHall cinemaHall , @PathVariable Integer cinemaid){
        Cinema cinema = cinemaService.getCinema(cinemaid);
        cinemaHall.setCinema(cinema);
        cinemaHallService.saveCinemaHall(cinemaHall);
    }


}
