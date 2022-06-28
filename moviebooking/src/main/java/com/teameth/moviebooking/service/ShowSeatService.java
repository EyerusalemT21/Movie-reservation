package com.teameth.moviebooking.service;

import com.teameth.moviebooking.domain.ShowSeat;
import com.teameth.moviebooking.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatService {
    @Autowired
    ShowSeatRepository showSeatRepository;

    public void saveShowSeat(ShowSeat showSeat){
        showSeatRepository.save(showSeat);
    }

   public List<ShowSeat> getListOFShowSeatsByScheduleID(Integer scheduleId){
        return showSeatRepository.findByMovieScheduleMovieScheduleId(scheduleId);
   }


}
