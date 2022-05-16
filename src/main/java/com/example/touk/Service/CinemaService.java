package com.example.touk.Service;

import com.example.touk.model.Cinema;

import java.util.List;

public interface CinemaService {
    Cinema saveCinema(Cinema cinema);
    List<Cinema> getAllCinemas();
    Cinema getCinemaByID(Long id);
    Cinema updateCinema(Cinema cinema, Long id);
    void deleteCinema(Long id);
    Cinema addHall(Long cinemaId, Long hallId);
    Cinema removeHall(Long cartId, Long itemId);
}
