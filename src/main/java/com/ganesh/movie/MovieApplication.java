package com.ganesh.movie;

import com.ganesh.bean.Movie;
import com.ganesh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ganesh")
@EnableJpaRepositories(basePackages = "com.ganesh.persistence")
@EntityScan(basePackages = "com.ganesh.bean")
public class MovieApplication implements CommandLineRunner {
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }


    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

    @Override
    public void run(String... args) {
        movieService.insertMovie(new Movie( "Race"));
        movieService.insertMovie(new Movie( "Titanic"));
        movieService.insertMovie(new Movie( "Fast And Furious"));
        movieService.insertMovie(new Movie( "Mr Bean"));
        movieService.insertMovie(new Movie( "Avengers"));


    }
}
