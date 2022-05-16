package com.example.touk.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name ="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String filmDirevtor;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movie")
    private List<FilmShow> FilmShows = new ArrayList<>();

    public void addFilmShow(FilmShow filmShow){
        FilmShows.add(filmShow);
    }

    public void removeFilmShow(FilmShow filmShow){
        FilmShows.remove(filmShow);
    }

}
