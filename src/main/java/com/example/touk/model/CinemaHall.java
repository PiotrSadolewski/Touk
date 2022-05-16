package com.example.touk.model;

import com.example.touk.model.dto.CinemaHallDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="cinemaHall")
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int seats;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinema_id", referencedColumnName = "Id")
    private Cinema cinema;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cinemaHall")
    private List<FilmShow> FilmShows = new ArrayList<>();

    public void addFilmShow(FilmShow filmShow){
        FilmShows.add(filmShow);
    }

    public void addFilmshow(FilmShow filmShow){
        FilmShows.remove(filmShow);
    }

    public static CinemaHall from(CinemaHallDto cinemaHallDto){
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setSeats(cinemaHallDto.getSeats());
        return cinemaHall;
    }


}
