package com.example.movie_list.Service;

import com.example.movie_list.MovieListDuplicatedException;
import com.example.movie_list.MovieListNotFoundException;
import com.example.movie_list.MovieListValidationException;
import com.example.movie_list.dao.MovieListMapper;
import com.example.movie_list.entity.Movie;
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
        if (name == null || name.trim().isEmpty() || leadActor == null || leadActor.trim().isEmpty()) {
            throw new MovieListValidationException("Name and leadActor must not be empty");
        }

        if (boxOffice == null || boxOffice < 0) {
            throw new MovieListValidationException("Box office must be 0 or greater");
        }
        this.movieListMapper.findByName(name)
                .ifPresent(m -> {
                    throw new MovieListDuplicatedException("Movies already exists");
                });

        Movie movie = new Movie(null, name, releaseDate, leadActor, boxOffice);
        movieListMapper.insert(movie);
        return movie;
    }

    public void update(Integer id, String name, Date releaseDate, String leadActor, int boxOffice) {
        Movie existingMovie = movieListMapper.findById(id)
                .orElseThrow(() -> new MovieListNotFoundException("Movie with id " + id + " not found"));

        Optional<Movie> duplicatedMovie = movieListMapper.findByName(name);
        duplicatedMovie.ifPresent(movie -> {
            if (!movie.getId().equals(id)) {
                throw new MovieListDuplicatedException("Movie already exists");
            }
        });
        existingMovie.setName(name);
        existingMovie.setReleaseDate(releaseDate);
        existingMovie.setLeadActor(leadActor);
        existingMovie.setBoxOffice(boxOffice);
        movieListMapper.update(existingMovie);
    }

    public void delete(Integer id) {
        Movie movie = movieListMapper.findById(id)
                .orElseThrow(() -> new MovieListNotFoundException("Movie with id " + id + " not found"));
        movieListMapper.delete(id);
    }
}
