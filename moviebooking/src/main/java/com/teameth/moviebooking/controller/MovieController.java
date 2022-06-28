package com.teameth.moviebooking.controller;

import com.teameth.moviebooking.domain.Location;
import com.teameth.moviebooking.domain.Movie;
import com.teameth.moviebooking.service.LocationService;
import com.teameth.moviebooking.service.MovieScheduleService;
import com.teameth.moviebooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieScheduleService movieScheduleService;



    @RequestMapping("/movie")
    public List<Movie> getAllLocations(){
        return movieService.getAllMovies();
    }

    /*@RequestMapping("/movie/{movieId}")
    public Movie getmovieById(@PathVariable Integer id){
        return movieService.getMovie(id);
    }*/

    @RequestMapping("/movie/{movieTitle}")
    public Movie getMovieByName(String movieTitle){
        return movieService.getMovieByName(movieTitle);
    }

    @RequestMapping(method = RequestMethod.POST ,value="/movie")
    public void saveNewLocation(@RequestBody Movie movie){
        movieService.saveMovie(movie);
    }
/*
    @RequestMapping("/movie/{movieId}")
    public Movie getScheduleByMovieId(@PathVariable Integer movieId){
        movieScheduleService.getScheduleByMovieId(movieId);
        return movieService.getMovie(id);
    }*/
}
