package com.example.touk.model;

import com.example.touk.model.dto.CinemaDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adres;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cinema")
    private List<CinemaHall> cinemaHalls = new ArrayList<>();

    public void addCinemaHall(CinemaHall cinemaHall){
        cinemaHalls.add(cinemaHall);
    }

    public void removeCinemaHall(CinemaHall cinemaHall){
        cinemaHalls.remove(cinemaHall);
    }

    public static Cinema from(CinemaDto cartDto){
        Cinema cinema = new Cinema();
        cinema.setName(cartDto.getName());
        cinema.setAdres(cinema.getAdres());
        return cinema;
    }

}
