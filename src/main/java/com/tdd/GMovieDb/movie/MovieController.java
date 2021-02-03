package com.tdd.GMovieDb.movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getMovieList")
    public ResponseEntity<List<MovieDto>> getMovieList(){
        return new ResponseEntity<List<MovieDto>>(movieService.getMovieList(), HttpStatus.OK);
    }

    @PostMapping("/addMovie")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMovieList(MovieDto movieDto){
        movieService.addMovieList(movieDto);
    }

}
