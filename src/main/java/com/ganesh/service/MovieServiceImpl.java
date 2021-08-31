package com.ganesh.service;


import com.ganesh.bean.Movie;
import com.ganesh.bean.MovieList;
import com.ganesh.persistence.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MovieServiceImpl implements MovieService{

    private MovieDao movieDao;

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public MovieList getAllMovies() {
        return new MovieList(movieDao.findAll());
    }

    @Override
    public Movie insertMovie(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieById(int id) {
        return movieDao.getById(id);


    }

    @Override
    public Movie getMovieByName(String name) {
        return movieDao.getMovieByName(name);
    }

    @Override
    public Movie deleteMovieById(int id) {
        Movie movie = movieDao.getById(id);
        movieDao.deleteById(id);
        return movie;
    }

    @Override
    public Movie updateMovieName(int id, String name) {
        int rows = movieDao.updateMovieName(id, name);
        if(rows > 0) return movieDao.getById(id);
        return null;
    }


}