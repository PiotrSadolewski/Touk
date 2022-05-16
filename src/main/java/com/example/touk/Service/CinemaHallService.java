package com.example.touk.Service;
import com.example.touk.model.CinemaHall;

import java.util.List;
public interface CinemaHallService {
    CinemaHall saveCinemaHall(CinemaHall cinemaHall);
    List<CinemaHall> getAllCinemaHalls();
    CinemaHall getCinemaHallByID(Long id);
    CinemaHall updateCinemaHall(CinemaHall cinemaHall, Long id);
    void deleteCinemaHall(Long id);
}
