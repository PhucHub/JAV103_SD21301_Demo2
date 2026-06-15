package com.jav103.jav103_sum26_demo2.services;

import com.jav103.jav103_sum26_demo2.entity.Movie;
import com.jav103.jav103_sum26_demo2.repository.MovieRepository;

import java.util.List;

public class MovieServices {

    private final MovieRepository movieRepository = new MovieRepository();

    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.getMovieById(id);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteMovie(id);
    }

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void editMovie(Movie movie) {
        movieRepository.editMovie(movie);
    }
}
