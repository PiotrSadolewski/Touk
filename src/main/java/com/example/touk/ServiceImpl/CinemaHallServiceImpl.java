package com.example.touk.ServiceImpl;

import com.example.touk.Service.CinemaHallService;
import com.example.touk.model.Cinema;
import com.example.touk.model.CinemaHall;
import com.example.touk.repository.CinemaHallRepository;
import com.example.touk.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallRepository cinemaHallRepository;
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallsRepository, CinemaRepository cinemaRepository) {
        this.cinemaHallRepository = cinemaHallsRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public CinemaHall saveCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAllCinemaHalls() {
        return cinemaHallRepository.findAll();
    }

    @Override
    public CinemaHall getCinemaHallByID(Long id) {
        return cinemaHallRepository.findById(id).orElseThrow(() ->
        new IllegalArgumentException("could not find cinemaHall with id: " + id));
    }

    @Override
    public CinemaHall updateCinemaHall(CinemaHall cinemaHall, Long id) {
        CinemaHall existingCinemaHall = cinemaHallRepository.findById(id).orElseThrow();
        existingCinemaHall.setSeats(cinemaHall.getSeats());
        cinemaHallRepository.save(existingCinemaHall);
        return existingCinemaHall;
    }

    @Override
    public void deleteCinemaHall(Long id) {
        CinemaHall deleteCinemaHall = cinemaHallRepository.findById(id).orElseThrow();
        cinemaHallRepository.delete(deleteCinemaHall);
    }
}
