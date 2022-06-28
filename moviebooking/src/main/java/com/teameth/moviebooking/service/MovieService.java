package com.teameth.moviebooking.service;

import com.teameth.moviebooking.domain.Movie;
import com.teameth.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    
    @Autowired
    MovieRepository movieRepository;


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id).get();
    }

    public Movie getMovieDetail(Integer id) {
        return movieRepository.findById(id).get();
    }


    public Movie getMovieByName(String movieTitle) {
        return movieRepository.findByTitle(movieTitle);
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

}
