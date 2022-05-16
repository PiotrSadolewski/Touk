package com.example.touk.model;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name ="filmshow")
public class FilmShow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate filmStart;
    private LocalDate filmEnd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cinemahall_id", referencedColumnName = "Id")
    private CinemaHall cinemaHall;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", referencedColumnName = "Id")
    private Movie movie;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "filmShow")
    private List<Ticket> tickets = new ArrayList<>();

    public void addCinemaHall(Ticket ticket){
        tickets.add(ticket);
    }

    public void removeCinemaHall(Ticket ticket){
        tickets.remove(ticket);
    }
}
