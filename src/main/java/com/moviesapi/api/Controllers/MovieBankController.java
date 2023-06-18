package com.moviesapi.api.Controllers;

import com.moviesapi.api.Models.Movie;
import com.moviesapi.api.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieBankController {
    @Autowired
    private MovieRepo movieRepo;

    @GetMapping(value = "/movies")
    public List<Movie> getMovies(){
        return movieRepo.findAll();
    }

    @GetMapping(value = "/movie/{id}")
    public Movie getMovie(@PathVariable long id){
      Movie foundMovie = movieRepo.findById(id).get();
      return foundMovie;
    }

    @PostMapping(value = "/add")
    public String addMovie(@RequestBody Movie movie){
        movieRepo.save(movie);
        return "Added movie to database";
    }

    @PutMapping(value = "/update/{id}")
    public String updateMovie(@PathVariable long id, @RequestBody Movie movie){
        Movie updatedMovie = movieRepo.findById(id).get();
        updatedMovie.setMovie_name(movie.getMovie_name());
        movieRepo.save(updatedMovie);
        return "Successfully updated movie";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteMovie(@PathVariable long id){
        Movie deletedMovie = movieRepo.findById(id).get();
        movieRepo.delete(deletedMovie);
        return "Deleted movie with id: " + id;
    }
}
