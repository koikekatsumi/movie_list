package com.example.movie_list;

import java.util.Date;

public class Movie {

    private int id;
    private String name;

    private Date releaseDate;

    private String leadActor;
    private int boxOffice;

    public Movie(int id, String name, Date releaseDate, String leadActor, int boxOffice) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.leadActor = leadActor;
        this.boxOffice = boxOffice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public int getBoxOffice() {
        return boxOffice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public void setBoxOffice(int boxOffice) {
        if (boxOffice >= 0) {
            this.boxOffice = boxOffice;
        } else {
            throw new IllegalArgumentException("興行収入は、正の数0以上でなければなりません。");
        }
    }
}

