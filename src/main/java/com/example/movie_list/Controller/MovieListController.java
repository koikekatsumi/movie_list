package com.example.movie_list.Controller;

import com.example.movie_list.Service.MovieListService;
import com.example.movie_list.entity.Movie;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class MovieListController {
    private MovieListService movieListService;

    @Autowired
    public MovieListController(MovieListService movieListService) {
        this.movieListService = movieListService;
    }

    @GetMapping("/movies/{id}")
    public Movie findMovie(@Valid @PathVariable("id") int id) {
        return movieListService.findMovie(id);
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieListResponse> insert(@RequestBody @Validated MovieListRequest movieListRequest, UriComponentsBuilder uriBuilder) {
        Movie movie = movieListService.insert(movieListRequest.getName(), movieListRequest.getReleaseDate(), movieListRequest.getLeadActor(), movieListRequest.getBoxOffice());
        URI location = uriBuilder.path("/movies/{id}").buildAndExpand(movie.getId()).toUri();
        MovieListResponse newMovie = new MovieListResponse("New movie is created");
        return ResponseEntity.created(location).body(newMovie);
    }

    @PatchMapping("/movies/{id}")
    public ResponseEntity<MovieListResponse> update(@PathVariable("id") Integer id, @RequestBody @Valid MovieListRequest movieListRequest) {
        movieListService.update(id, movieListRequest.getName(), movieListRequest.getReleaseDate(), movieListRequest.getLeadActor(), movieListRequest.getBoxOffice());
        MovieListResponse updateMovie = new MovieListResponse("movie updated");
        return ResponseEntity.ok(updateMovie);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<MovieListResponse> delete(@PathVariable("id") Integer id) {
        movieListService.delete(id);
        MovieListResponse body = new MovieListResponse("movie deleted");
        return ResponseEntity.ok(body);
    }
}
