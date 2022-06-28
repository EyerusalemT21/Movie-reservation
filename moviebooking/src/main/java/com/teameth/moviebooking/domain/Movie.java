package com.teameth.moviebooking.domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieid;

    private String title;
    private int published_year;
    private String description;

    private String imagePath;

    private String genre;

    //private List<MovieSchedule> schedules;
    public Movie() {
    }

    public int getmovieid() {
        return movieid;
    }

    public void setmovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublished_year() {
        return published_year;
    }

    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }

    public String getDescription() {
        return description;
    }

    public Movie(int movieid, String title, int published_year, String description, String genre) {
        this.movieid = movieid;
        this.title = title;
        this.published_year = published_year;
        this.description = description;
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
