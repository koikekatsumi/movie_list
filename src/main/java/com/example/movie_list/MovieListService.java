package com.example.movie_list;

import org.springframework.stereotype.Service;

@Service
public class MovieListService {
    private MovieListMapper movieListMapper;

    public MovieListService(MovieListMapper movieListMapper) {
        this.movieListMapper = movieListMapper;
    }

    public Movie findMovie(int id) {
        return movieListMapper.findById(id)
                .orElseThrow(() -> new MovieListNotFoundException("Movie with id " + id + " not found"));
    }
}


