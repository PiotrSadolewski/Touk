package com.example.touk.controller;

import com.example.touk.Service.CinemaService;
import com.example.touk.model.Cinema;
import com.example.touk.model.dto.CinemaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {


    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping
    public ResponseEntity<Cinema> saveCinema(@RequestBody Cinema cinema){
        return new ResponseEntity<Cinema>(cinemaService.saveCinema(cinema), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cinema> getAllCinemas(){
        return cinemaService.getAllCinemas();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cinema> getCinemaById(@PathVariable("id") long cinemaId){
        return new ResponseEntity<Cinema>(cinemaService.getCinemaByID(cinemaId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cinema> updateCinema(@PathVariable("id") long id, @RequestBody Cinema cinema){
        return new ResponseEntity<Cinema>(cinemaService.updateCinema(cinema, id), HttpStatus.OK);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteCinema(@PathVariable("id") long id){
        cinemaService.deleteCinema(id);
        return new ResponseEntity<String>("Cinema :"+ id + " deleted succesfully!", HttpStatus.OK);
    }

    @PostMapping(value = "{cinemaId}/hall/{hallId}/add")
    public ResponseEntity<CinemaDto> addHallToMovie(@PathVariable final Long cinemaId,
                                                   @PathVariable final Long hallId){
        Cinema cinema = cinemaService.addHall(cinemaId, hallId);
        return new ResponseEntity<>(CinemaDto.from(cinema), HttpStatus.OK);
    }

    @DeleteMapping(value = "{cinemaId}/hall/{hallId}/remove")
    public ResponseEntity<CinemaDto> removeHall(@PathVariable final Long cinemaId,
                                                        @PathVariable final Long hallId){
        Cinema cinema = cinemaService.removeHall(cinemaId, hallId);
        return new ResponseEntity<>(CinemaDto.from(cinema), HttpStatus.OK);
    }
}
