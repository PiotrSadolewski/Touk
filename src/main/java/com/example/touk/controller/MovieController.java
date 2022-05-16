package com.example.touk.controller;

import com.example.touk.Service.MovieService;
import com.example.touk.model.Movie;
import com.example.touk.model.dto.MovieDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMoviesBy(@PathVariable("id") long movieID){
        return new ResponseEntity<Movie>(movieService.getMovieByID(movieID), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.updateMovie(movie, id), HttpStatus.OK);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteMovie(@PathVariable("id") long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<String>("Movie :"+ id + " deleted succesfully!", HttpStatus.OK);
    }

    @PostMapping(value = "{movieId}/hall/{filmShowId}/add")
    public ResponseEntity<MovieDto> addMovieToFilmShow(@PathVariable final Long movieId,
                                                  @PathVariable final Long filmShowId){
        Movie movie = movieService.addFilmShow(movieId, filmShowId);
        return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);
    }

    @DeleteMapping(value = "{movieId}/hall/{filmShowId}/add")
    public ResponseEntity<MovieDto> deleteFilmShow(@PathVariable final Long movieId,
                                                  @PathVariable final Long filmShowId){
        Movie movie = movieService.removeFilmShow(movieId, filmShowId);
        return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);
    }
}
