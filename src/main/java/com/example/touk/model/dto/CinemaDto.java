package com.example.touk.model.dto;

import com.example.touk.model.Cinema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CinemaDto {
    private Long id;
    private String name;
    private String adres;
    private List<CinemaHallDto> cinemaHallDto = new ArrayList<>();

    public static CinemaDto from(Cinema cinema){
        CinemaDto cinemaDto = new CinemaDto();
        cinemaDto.setId(cinema.getId());
        cinemaDto.setName(cinema.getName());
        cinemaDto.setCinemaHallDto(cinema.getCinemaHalls().stream().map(CinemaHallDto::from).collect(Collectors.toList()));
        return cinemaDto;
    }
}
