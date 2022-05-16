package com.example.touk.model.dto;

import com.example.touk.model.Movie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MovieDto {
    private Long id;
    private String title;
    private String filmDirector;
    private List<FilmShowDto> filmShowsDto = new ArrayList<>();

    public static MovieDto from(Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setFilmDirector(movie.getFilmDirevtor());
        movieDto.setFilmShowsDto(movie.getFilmShows().stream().map(FilmShowDto::from).collect(Collectors.toList()));
        return movieDto;
    }
}
