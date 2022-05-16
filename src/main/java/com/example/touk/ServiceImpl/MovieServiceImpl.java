package com.example.touk.ServiceImpl;

import com.example.touk.Service.MovieService;
import com.example.touk.model.FilmShow;
import com.example.touk.model.Movie;
import com.example.touk.repository.FIlmShowRepository;
import com.example.touk.repository.MovieRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final FIlmShowRepository fIlmShowRepository;

    public MovieServiceImpl(MovieRepository movieRepository, FIlmShowRepository fIlmShowRepository) {
        this.movieRepository = movieRepository;
        this.fIlmShowRepository = fIlmShowRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieByID(Long id) {
        return movieRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find Movie with id: " + id));
    }

    @Override
    public Movie updateMovie(Movie movie, Long id) {
        Movie existingMovie = movieRepository.findById(id).orElseThrow();
        existingMovie.setFilmDirevtor(movie.getFilmDirevtor());
        existingMovie.setTitle(movie.getTitle());
        return existingMovie;
    }

    @Override
    public void deleteMovie(Long id) {
        Movie deleteMovie = movieRepository.findById(id).orElseThrow();
        movieRepository.delete(deleteMovie);
    }

    @Transactional
    @Override
    public Movie addFilmShow(Long movieId, Long filmShowId) {
        Movie movie = getMovieByID(movieId);
        FilmShow filmShow = fIlmShowRepository.getById(filmShowId);
        movie.addFilmShow(filmShow);
        filmShow.setMovie(movie);
        return movie;
    }

    @Transactional
    @Override
    public Movie removeFilmShow(Long movieId, Long filmShowId) {
        Movie movie = getMovieByID(movieId);
        FilmShow filmShow = fIlmShowRepository.getById(filmShowId);
        movie.removeFilmShow(filmShow);
        return movie;
    }
}
