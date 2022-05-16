package com.example.touk.model.dto.Plain;

import com.example.touk.model.Cinema;
import lombok.Data;

@Data
public class PlainCinemaDto {
    private Long id;
    private String name;
    private String adres;

    public static PlainCinemaDto from(Cinema cinema){
        PlainCinemaDto plainCinematDto = new PlainCinemaDto();
        plainCinematDto.setId(cinema.getId());
        plainCinematDto.setName(cinema.getName());
        plainCinematDto.setAdres(cinema.getAdres());
        return plainCinematDto;
    }
}
