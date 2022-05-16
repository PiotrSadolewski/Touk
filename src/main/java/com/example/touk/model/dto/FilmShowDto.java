package com.example.touk.model.dto;

import com.example.touk.model.FilmShow;
import com.example.touk.model.dto.Plain.PlainMovieDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class FilmShowDto {
    private Long id;
    private LocalDate filmStart;
    private LocalDate filmEnd;
    private PlainMovieDto plainMovieDto;

    public static FilmShowDto from(FilmShow filmShow){
        FilmShowDto filmShowDto = new FilmShowDto();
        filmShowDto.setId(filmShow.getId());
        filmShowDto.setFilmEnd(filmShow.getFilmEnd());
        filmShowDto.setFilmStart(filmShow.getFilmStart());
        if(Objects.nonNull(filmShow.getMovie())){
            filmShowDto.setPlainMovieDto(PlainMovieDto.from(filmShow.getMovie()));
        }
        return filmShowDto;
    }
}
