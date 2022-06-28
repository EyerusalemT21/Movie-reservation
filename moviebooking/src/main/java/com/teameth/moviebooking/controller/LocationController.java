package com.teameth.moviebooking.controller;

import com.teameth.moviebooking.domain.*;
import com.teameth.moviebooking.service.CinemaHallService;
import com.teameth.moviebooking.service.CinemaService;
import com.teameth.moviebooking.service.LocationService;
import com.teameth.moviebooking.service.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private CinemaHallService cinemaHallService;

    @Autowired
    private MovieScheduleService movieScheduleService;

    @RequestMapping("/location")
    public List<Location> getAllLocations(){
        return locationService.getAllLocation();
    }

    @RequestMapping(method = RequestMethod.POST ,value="/location")
    public void saveNewLocation(@RequestBody Location location){

        locationService.saveLocation(location);
    }


    @RequestMapping(method = RequestMethod.GET ,value="/location/{id}")
    public List<Movie> getMoviesLocation(@PathVariable Integer id){
        List<Movie> movies = new ArrayList<>();
        List<Cinema> cinemas = cinemaService.getByLocation(id);
        cinemas.forEach(cinema -> {
            List<CinemaHall> halls = cinemaHallService.getCinemaHallByCinema(cinema.getCinema_id());
            //List<CinemaHall> halls = cinema.getCinemaHallList();
            halls.forEach( hall -> {
               List<MovieSchedule> schedules = movieScheduleService.getMovieScheduleByHall(hall.getHall_id());
               if(schedules != null){
               schedules.forEach(schedule -> {
                   if( (schedule.getDate().after(Date.valueOf(LocalDate.now()))) ||
                           (   schedule.getDate().toLocalDate().equals(LocalDate.now())
                                   &&  schedule.getStart_time().toLocalTime().compareTo(LocalTime.now()) > 0
                           )
                   ) {
                       Movie movie = schedule.getMovie();
                       if (movie != null) {
                           movies.add(movie);
                       }
                   }
               });}
            });
         });

        return  movies;
        //locationService.saveLocation(location);
    }
}
