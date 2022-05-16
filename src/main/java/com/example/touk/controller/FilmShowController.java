package com.example.touk.controller;

import com.example.touk.Service.FilmShowService;
import com.example.touk.model.FilmShow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmShows")
public class FilmShowController {
    private final FilmShowService filmShowService;

    public FilmShowController(FilmShowService filmShowService) {
        this.filmShowService = filmShowService;
    }

    @PostMapping
    public ResponseEntity<FilmShow> saveFilmShow(@RequestBody FilmShow filmShow){
        return new ResponseEntity<FilmShow>(filmShowService.saveFilmshow(filmShow), HttpStatus.CREATED);
    }

    @GetMapping
    public List<FilmShow> getAllFilmShows(){
        return filmShowService.getAllFilmShows();
    }

    @GetMapping("{id}")
    public ResponseEntity<FilmShow> getFilmShowBY(@PathVariable("id") long filmShowID){
        return new ResponseEntity<FilmShow>(filmShowService.getFilmShowById(filmShowID), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<FilmShow> updateFilmShow(@PathVariable("id") long id, @RequestBody FilmShow filmShow){
        return new ResponseEntity<FilmShow>(filmShowService.updateFilmShow(filmShow, id), HttpStatus.OK);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteFilmShow(@PathVariable("id") long id){
        filmShowService.deleteFilmShow(id);
        return new ResponseEntity<String>("Order :"+ id + " deleted succesfully!", HttpStatus.OK);
    }

}
