package com.ganesh.service;

import com.ganesh.bean.Movie;
import com.ganesh.bean.MovieList;



public interface MovieService {

    MovieList getAllMovies();
    Movie insertMovie(Movie movie);
    Movie getMovieById(int id);
    Movie getMovieByName(String name);
    Movie deleteMovieById(int id);
    Movie updateMovieName(int id, String name);
}