package com.ganesh.service;

import com.ganesh.bean.Movie;

import java.util.Collection;


public interface MovieService {

    Collection<Movie> getAllMovies();
    Movie insertMovie(Movie movie);
    Movie getMovieById(int id);
    Movie deleteMovieById(int id);
    Movie updateMovieName(int id, String name);
}