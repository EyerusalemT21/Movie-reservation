package com.teameth.moviebooking.repository;

import com.teameth.moviebooking.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    public Movie findByTitle(String title);
}
