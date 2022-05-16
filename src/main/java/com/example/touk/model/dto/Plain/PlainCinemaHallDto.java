package com.example.touk.model.dto.Plain;

import com.example.touk.model.CinemaHall;
import lombok.Data;

@Data
public class PlainCinemaHallDto {
    private Long id;
    private int seats;

    public static PlainCinemaHallDto from(CinemaHall cinemaHall){
        PlainCinemaHallDto plainCinemaHallDto = new PlainCinemaHallDto();
        plainCinemaHallDto.setId(cinemaHall.getId());
        plainCinemaHallDto.setSeats(cinemaHall.getSeats());
        return plainCinemaHallDto;
    }
}
