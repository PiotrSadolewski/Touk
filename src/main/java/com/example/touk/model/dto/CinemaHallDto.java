package com.example.touk.model.dto;

import com.example.touk.model.CinemaHall;
import com.example.touk.model.dto.Plain.PlainCinemaDto;
import lombok.Data;

import java.util.Objects;

@Data
public class CinemaHallDto {
    private Long id;
    private int seats;
    private PlainCinemaDto plainCinematDto;

    public static CinemaHallDto from(CinemaHall cinemaHall){
        CinemaHallDto cinemaHallDto = new CinemaHallDto();
        cinemaHallDto.setId(cinemaHall.getId());
        cinemaHallDto.setSeats(cinemaHall.getSeats());
        if(Objects.nonNull(cinemaHall.getCinema())){
            cinemaHallDto.setPlainCinematDto(PlainCinemaDto.from(cinemaHall.getCinema()));
        }
        return cinemaHallDto;
    }
}
