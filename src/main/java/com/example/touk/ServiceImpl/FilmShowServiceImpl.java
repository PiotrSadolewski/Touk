package com.example.touk.ServiceImpl;

import com.example.touk.Service.FilmShowService;
import com.example.touk.model.FilmShow;
import com.example.touk.repository.FIlmShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmShowServiceImpl implements FilmShowService {
    private final FIlmShowRepository fIlmShowRepository;

    public FilmShowServiceImpl(FIlmShowRepository fIlmShowRepository) {
        this.fIlmShowRepository = fIlmShowRepository;
    }

    @Override
    public FilmShow saveFilmshow(FilmShow filmShow) {
        return fIlmShowRepository.save(filmShow);
    }

    @Override
    public List<FilmShow> getAllFilmShows() {
        return fIlmShowRepository.findAll();
    }

    @Override
    public FilmShow getFilmShowById(Long id) {
        return null;
    }

    @Override
    public FilmShow updateFilmShow(FilmShow filmShow, Long id) {
        FilmShow existingFilmShow = fIlmShowRepository.findById(id).orElseThrow();
        existingFilmShow.setFilmStart(filmShow.getFilmStart());
        existingFilmShow.setFilmEnd(filmShow.getFilmStart());
        existingFilmShow.setCinemaHall(filmShow.getCinemaHall());
        existingFilmShow.setMovie(filmShow.getMovie());
        existingFilmShow.setTickets(filmShow.getTickets());
        fIlmShowRepository.save(existingFilmShow);
        return existingFilmShow;
    }

    @Override
    public void deleteFilmShow(Long id) {
        FilmShow deleteFilmShow = fIlmShowRepository.findById(id).orElseThrow();
        fIlmShowRepository.delete(deleteFilmShow);
    }
}
