package com.example.movie_list;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MovieListService {
    private final MovieListMapper movieListMapper;

    public MovieListService(MovieListMapper movieListMapper) {

        this.movieListMapper = movieListMapper;
    }

    public Movie findMovie(int id) {
        return movieListMapper.findById(id)
                .orElseThrow(() -> new MovieListNotFoundException("Movie with id " + id + " not found"));
    }

    public Movie insert(String name, Date releaseDate, String leadActor, Integer boxOffice) {
        Movie movie = new Movie(null, name, releaseDate, leadActor, boxOffice);
        movieListMapper.insert(movie);
        return movie;
    }

    public void update(Integer id, String name, Date releaseDate, String leadActor, int boxOffice) {
        Optional<Movie> existingMovie = movieListMapper.findById(id);
        if (!existingMovie.isPresent()) {
            throw new MovieListNotFoundException("Movie not found");
        }
        Movie movie = existingMovie.get();
        movie.setName(name);
        movie.setReleaseDate(releaseDate);
        movie.setLeadActor(leadActor);
        movie.setBoxOffice(boxOffice);
        movieListMapper.update(movie);
    }


}

