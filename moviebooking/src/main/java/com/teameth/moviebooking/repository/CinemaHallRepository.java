package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.Cinema;
import com.teameth.moviebooking.domain.CinemaHall;
import com.teameth.moviebooking.service.CinemaHallService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface CinemaHallRepository extends JpaRepository<CinemaHall,Integer> {

    /*public default List<CinemaHall> getCinemaCinemaId(Integer id){
        return      findAll().
                    stream().filter(hall -> hall.getCinema().getCinema_id() == id)
                    .collect(Collectors.toList());
    }*/
    public List<CinemaHall> findByCinemaCinemaId(Integer id);
}
