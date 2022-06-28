package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema,Integer> {

    public List<Cinema> findByLocationId(Integer id);
}
