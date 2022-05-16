package com.example.touk.Service;

import com.example.touk.model.FilmShow;

import java.util.List;

public interface FilmShowService {
    FilmShow saveFilmshow(FilmShow filmShow);
    List<FilmShow> getAllFilmShows();
    FilmShow getFilmShowById(Long id);
    FilmShow updateFilmShow(FilmShow filmShow, Long id);
    void deleteFilmShow(Long id);
}
