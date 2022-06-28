package com.teameth.moviebooking.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teameth.moviebooking.domain.Cinema;
import com.teameth.moviebooking.domain.CinemaHall;
import com.teameth.moviebooking.domain.Location;
import com.teameth.moviebooking.models.CinemaRequest;
import com.teameth.moviebooking.service.CinemaHallService;
import com.teameth.moviebooking.service.CinemaService;
import com.teameth.moviebooking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaController {


    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private CinemaHallService cinemaHallService;



    @RequestMapping("/cinema")
    public List<Cinema> getAllLocations(){
        return cinemaService.getAllCinema();
    }
    @RequestMapping(method = RequestMethod.POST ,value="/{locationid}/cinema")
    public void saveNewCinema(@RequestBody Cinema cinema ,@PathVariable Integer locationid){
        Location location = locationService.getSpecificLocation(locationid);
        cinema.setLocation(location);
        cinemaService.saveCinema(cinema);
    }


   /* @RequestMapping(method = RequestMethod.POST ,value="/{locationid}/cinema")
    public void saveNewLocation(@RequestBody Cinema cinema ,@PathVariable Integer locationid){
         Location location = locationService.getSpecificLocation(locationid);
        cinema.setLocation(location);
        cinemaService.saveCinema(cinema);
    }*/
   /* @RequestMapping(method = RequestMethod.POST ,value="/{locationid}/cinema")
    public void saveNewCinenmaAndHalls(@RequestBody CinemaRequest cinemaRequest , @PathVariable Integer locationid) throws JsonProcessingException {
        Location location = locationService.getSpecificLocation(locationid);
      //  cinema.setLocation(location);
        System.out.println(cinemaRequest.getCinemaHallList());
        Cinema cinema = new Cinema( 11,cinemaRequest.getCinema_name(),locationid,5);
        //List<CinemaHall> cinemaHall = cinemaRequest.getCinemaHalls();
        cinema.setLocation(location);
       // for(CinemaHall c :cinemaHall){
        //    cinemaHallService.saveCinemaHall(c);
        }
        //
        //cinemaService.saveCinema(cinema);
    }*/



}
