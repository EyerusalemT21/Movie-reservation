package com.teameth.moviebooking.service;

import com.teameth.moviebooking.domain.Cinema;
import com.teameth.moviebooking.domain.HallSeat;
import com.teameth.moviebooking.domain.ShowSeat;
import com.teameth.moviebooking.repository.CinemaRepository;
import com.teameth.moviebooking.repository.HallSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HallSeatService {

    @Autowired
    private HallSeatRepository hallSeatRepository;



    public List<HallSeat> getAllHallSeat(){
        List<HallSeat> hallSeats= new ArrayList<>();
        return hallSeatRepository.findAll();
    }

    public HallSeat getHallSeat(Integer seatId){
        return hallSeatRepository.findById(seatId).get();
    }


    public void saveHallSeat(HallSeat hallSeat){
        hallSeatRepository.save(hallSeat);
    }
    public List<HallSeat> getHallSeatsByHallid(Integer id){
        return hallSeatRepository.findByCinemaHallHallId(id);
    }



}
