package com.ganesh.resources;


import com.ganesh.bean.Movie;
import com.ganesh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/movies")
public class MovieResource {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping(produces = "Application/json")
    Collection<Movie> findAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(path = "/{id}", produces = "Application/json")
    Movie getMovieById(@PathVariable("id") int id) {
        return movieService.getMovieById(id);
    }

    @GetMapping(path = "/xml/{id}", produces = "Application/xml")
    public Movie getXmlMovieById(@PathVariable("id") int id) {
        return movieService.getMovieById(id);
    }

    @PostMapping( produces = "Application/json", consumes = "Application/json")
    Movie saveMovie(@RequestBody Movie movie) {
        return movieService.insertMovie(movie);
    }


    @PutMapping(path = "/{id}/{name}", produces = "Application/json", consumes = "Application/json")
    Movie updateMovie(@PathVariable("id") int id, @PathVariable("name") String name) {
        return movieService.updateMovieName(id, name);
    }

    @DeleteMapping(path = "/{id}", produces = "Application/json", consumes = "Application/json")
    Movie deleteMovie(@PathVariable("id") int id) {
        return movieService.deleteMovieById(id);
    }
}