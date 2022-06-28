package com.teameth.moviebooking.service;

import com.teameth.moviebooking.domain.Cinema;
import com.teameth.moviebooking.domain.CinemaHall;
import com.teameth.moviebooking.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinema(){
        List<Cinema> Cinemas= new ArrayList<>();
        return cinemaRepository.findAll();
    }

    public Cinema getCinema(Integer cinemaId){
        return cinemaRepository.findById(cinemaId).get();
    }


    public void saveCinema(Cinema cinema){
        cinemaRepository.save(cinema);
    }


    public List<Cinema> getByLocation(Integer id) {
       return  cinemaRepository.findByLocationId(id);
    }


}
