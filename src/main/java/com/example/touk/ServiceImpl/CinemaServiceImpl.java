package com.example.touk.ServiceImpl;

import com.example.touk.Service.CinemaService;
import com.example.touk.model.Cinema;
import com.example.touk.model.CinemaHall;
import com.example.touk.repository.CinemaHallRepository;
import com.example.touk.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;
    private final CinemaHallRepository cinemaHallRepository;

    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository, CinemaHallRepository cinemaHallRepository) {
        this.cinemaRepository = cinemaRepository;
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema getCinemaByID(Long id) {
        return cinemaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find Cinema with id: " + id));
    }


    @Override
    @Transactional
    public Cinema updateCinema(Cinema cinema, Long id) {
        Cinema existingCinema = cinemaRepository.findById(id).orElseThrow();
        existingCinema.setName(cinema.getName());
        existingCinema.setAdres(cinema.getAdres());
        existingCinema.setCinemaHalls(cinema.getCinemaHalls());

        cinemaRepository.save(existingCinema);
        return existingCinema;
    }

    @Override
    public void deleteCinema(Long id) {
        Cinema deleteCinema = cinemaRepository.findById(id).orElseThrow();
        cinemaRepository.delete(deleteCinema);
    }

    @Override
    @Transactional
    public Cinema addHall(Long cinemaId, Long hallId) {
        Cinema cinema = getCinemaByID(cinemaId);
        CinemaHall cinemaHall = cinemaHallRepository.getById(hallId);
        cinema.addCinemaHall(cinemaHall);
        cinemaHall.setCinema(cinema);
        return cinema;
    }

    @Override
    @Transactional
    public Cinema removeHall(Long cinemaId, Long hallId){
        Cinema cinema = getCinemaByID(cinemaId);
        CinemaHall cinemaHall = cinemaHallRepository.getById(hallId);
        cinema.removeCinemaHall(cinemaHall);
        return cinema;
    }
}
