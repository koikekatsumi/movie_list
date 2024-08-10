package com.example.movie_list.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Movie {

    private Integer id;
    private String name;
    private LocalDate releaseDate;
    private String leadActor;
    private int boxOffice;

    public Movie(Integer id, String name, LocalDate releaseDate, String leadActor, Integer boxOffice) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.leadActor = leadActor;
        this.boxOffice = boxOffice;
    }

    public Movie(String name, LocalDate releaseDate, String leadActor, Integer boxOffice) {
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

    public LocalDate getReleaseDate() {
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

    public void setReleaseDate(LocalDate releaseDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        if (boxOffice != movie.boxOffice) return false;
        if (!Objects.equals(id, movie.id)) return false;
        if (!Objects.equals(name, movie.name)) return false;
        if (!Objects.equals(releaseDate, movie.releaseDate)) return false;
        return Objects.equals(leadActor, movie.leadActor);


        //  return boxOffice == movie.boxOffice && Objects.equals(id, movie.id) &&
        //         Objects.equals(name, movie.name) &&
        //        Objects.equals(releaseDate, movie.releaseDate) &&
        //      Objects.equals(leadActor, movie.leadActor) &&
        //     Objects.equals(boxOffice, movie.boxOffice);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (leadActor != null ? leadActor.hashCode() : 0);
        result = 31 * result + boxOffice;
        return result;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"releaseDate\":" + releaseDate + "\"leadActor\":" + leadActor + "\"boxOffice\":" + boxOffice + "\"}";
    }
}
