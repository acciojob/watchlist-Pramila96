package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("add_director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }
    @PostMapping("add_movie_director_pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director)
    {
        movieService.createMovieDirector(movie,director);
        return new ResponseEntity<>("Movie Director Pair added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get_movie_by_name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie movies=movieService.findMovie(name);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @GetMapping("/get_director_by_name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
     Director directors=movieService.findDirector(name);
     return new ResponseEntity<>(directors,HttpStatus.CREATED);
    }
    @GetMapping("/get_movies_by_director_name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director)
    {
        List<String> movies=movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @GetMapping("/get_all_movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> movies=movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete_director_by_name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director)
    {
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director+" Remove successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete_all_directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirector();
        return new ResponseEntity<>("All directors deleted successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get_director_name_from_movie")
    public String getDirectorName(@RequestParam String movie)
    {
        return movieService.getDirectorOfMovie(movie);
    }
}
