package com.example.movie_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Movie findMovie(@PathVariable("id") int id) {
        return movieListService.findMovie(id);
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieListResponse> insert(@RequestBody MovieListRequest movieListRequest, UriComponentsBuilder uriBuilder) {
        Movie movie = movieListService.insert(movieListRequest.getName(), movieListRequest.getReleaseDate(), movieListRequest.getLeadActor(), movieListRequest.getBoxOffice());
        URI location = uriBuilder.path("/movies/{id}").buildAndExpand(movie.getId()).toUri();
        MovieListResponse newMovie = new MovieListResponse("New movie is created");
        return ResponseEntity.created(location).body(newMovie);
    }

    @PatchMapping("/movies/{id}")
    public ResponseEntity<MovieListResponse> update(@PathVariable("id") Integer id, @RequestBody MovieListRequest movieListRequest) {
        movieListService.update(id, movieListRequest.getName(), movieListRequest.getReleaseDate(), movieListRequest.getLeadActor(), movieListRequest.getBoxOffice());
        MovieListResponse updateMovie = new MovieListResponse("movie updated");
        return ResponseEntity.ok(updateMovie);
    }
}
