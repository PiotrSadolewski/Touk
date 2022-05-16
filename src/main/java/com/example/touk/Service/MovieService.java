package com.example.touk.Service;
import com.example.touk.model.Movie;

import java.util.List;

public interface MovieService {
    Movie saveMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieByID(Long id);
    Movie updateMovie(Movie movie, Long id);
    void deleteMovie(Long id);
    Movie addFilmShow(Long movieId, Long filmShowId);
    Movie removeFilmShow(Long movieID, Long filmShowID);
}
