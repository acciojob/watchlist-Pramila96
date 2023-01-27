package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie)
    {
       movieRepository.addMovie(movie);
    }
    public void addDirector(Director director)
    {
        movieRepository.addDirector(director);
    }
    public void createMovieDirector(String movie,String director)
    {
        movieRepository.saveMovieDirector(movie,director);
    }
    public Movie findMovie(String movieName)
    {
        return movieRepository.findMovie(movieName);
    }
    public Director findDirector(String directorName)
    {
        return movieRepository.findDirector(directorName);
    }
    public List<String> findMoviesFromDirector(String director)
    {
        return movieRepository.findMoviesFromDirector(director);
    }
    public List<String> findAllMovies()
    {
        return movieRepository.findAllmovies();
    }
    public void deleteDirector(String director)
    {
        movieRepository.deleteDirector(director);
    }
    public void deleteAllDirector()
    {
        movieRepository.deleteAllDirector();
    }
    public String getDirectorOfMovie(String movieName)
    {
        return movieRepository.getDirectorOfMovie(movieName);
    }
}
