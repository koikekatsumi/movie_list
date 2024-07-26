package com.example.movie_list;

import java.util.Date;

public class Movie {

    private Integer id;
    private String name;
    private Date releaseDate;
    private String leadActor;
    private Integer boxOffice;

    public Movie(Integer id, String name, Date releaseDate, String leadActor, Integer boxOffice) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.leadActor = leadActor;
        this.boxOffice = boxOffice;
    }

    public Movie(String name, Date releaseDate, String leadActor, Integer boxOffice) {
        this.id = null;
        this.name = name;
        this.releaseDate = releaseDate;
        this.leadActor = leadActor;
        this.boxOffice = boxOffice;
    }

    public Integer getId() {
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

    public Integer getBoxOffice() {
        return boxOffice;
    }

    public void setId(Integer id) {
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

    public void setBoxOffice(Integer boxOffice) {
        if (boxOffice >= 0) {
            this.boxOffice = boxOffice;
        } else {
            throw new IllegalArgumentException("興行収入は、正の数0以上でなければなりません。");
        }
    }
}
