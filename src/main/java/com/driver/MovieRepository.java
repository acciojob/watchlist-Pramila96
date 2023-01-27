package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
   HashMap<String,Movie> movieMap;
   HashMap<String,Director> direcctorMap;

   HashMap<String, List<String>> directorMovieMap;

    public MovieRepository() {
        this.movieMap=new HashMap<String,Movie>();
        this.direcctorMap=new   HashMap<String,Director>();
        this.directorMovieMap=new HashMap<String, List<String>>();
    }

    public void addMovie( Movie movie)
   {
       movieMap.put(movie.getName(),movie);
   }
    public void addDirector(Director director)
    {
        direcctorMap.put(director.getName(),director);
    }
    public void saveMovieDirector(String movie,String director)
    {
       // MovieDirectorMap.put(movieMap.get(movie),direcctorMap.get(director));
        if(movieMap.containsKey(movie)&&direcctorMap.containsKey(director))
        {
            movieMap.put(movie,movieMap.get(movie));
            direcctorMap.put(director,direcctorMap.get(director));
            List<String> currentMovies=new ArrayList<>();
            if(directorMovieMap.containsKey(director))
                currentMovies=directorMovieMap.get(director);
            currentMovies.add(movie);
            directorMovieMap.put(director,currentMovies);
        }
    }
    public Movie findMovie(String movie)
    {
        return movieMap.get(movie);
    }
    public Director findDirector(String director)
    {
        return direcctorMap.get(director);
    }
    public List<String> findMoviesFromDirector(String director)
    {
        List<String> moviesList=new ArrayList<>();
        if(directorMovieMap.containsKey(director))
        {
            moviesList=directorMovieMap.get(director);
        }
        return moviesList;
    }
    public List<String> findAllmovies(){
        return new ArrayList<>(movieMap.keySet());
    }

public void deleteDirector(String director)
{
    List<String> movies=new ArrayList<>();
    if (directorMovieMap.containsKey(director))
    {
        movies=directorMovieMap.get(director);
        for (String movie:movies)
        {
            if(movieMap.containsKey(movie))
                movieMap.remove(movie);
        }
    }
    directorMovieMap.remove(director);
}
public void deleteAllDirector()
{
    HashSet<String> movieSet=new HashSet<>();
    for(String director:directorMovieMap.keySet())
    {
        for(String movie:directorMovieMap.get(director))
            movieSet.remove(movie);
    }
}
public String getDirectorOfMovie(String movie)
{
    HashSet<String> movieSet=new HashSet<>();
    for(String director:directorMovieMap.keySet())
    {
        if(directorMovieMap.get(director).contains(movie))
            return director;
    }
    return "NoMovieSuchFound";
}

}
