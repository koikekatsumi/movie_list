package com.example.movie_list;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieListService {
    private MovieListMapper movieListMapper;

    public MovieListService(MovieListMapper movieListMapper) {
        this.movieListMapper = movieListMapper;
    }

    public Movie findMovie(int id) {
        Optional<Movie> movie = movieListMapper.findById(id);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new UserNotFoundException("movie not found");
        }
    }
}

