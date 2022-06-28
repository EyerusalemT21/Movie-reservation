package com.teameth.moviebooking.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    private int id;
    private String name;
    private String State;
    private int zipCode;
    public Location() {
    }
   // private List<Cinema> cinemas;



    public Location(int id, String name, String state, int zipCode) {
        this.id = id;
        this.name = name;
        State = state;
        this.zipCode = zipCode;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }



}
