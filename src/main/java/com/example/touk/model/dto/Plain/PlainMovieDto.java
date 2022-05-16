package com.example.touk.model.dto.Plain;

import com.example.touk.model.Movie;
import lombok.Data;

@Data
public class PlainMovieDto {
    private Long id;
    private String title;
    private String filmDirector;

    public static PlainMovieDto from(Movie movie){
        PlainMovieDto plainMovieDto = new PlainMovieDto();
        plainMovieDto.setId(movie.getId());
        plainMovieDto.setTitle(movie.getTitle());
        plainMovieDto.setFilmDirector(movie.getFilmDirevtor());
        return plainMovieDto;
    }
}
