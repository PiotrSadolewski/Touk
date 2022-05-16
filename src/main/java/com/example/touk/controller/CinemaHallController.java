package com.example.touk.controller;

import com.example.touk.Service.CinemaHallService;
import com.example.touk.model.CinemaHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemaHalls")
public class CinemaHallController {


    private final CinemaHallService cinemaHallService;

    @Autowired
    public CinemaHallController(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping
    public ResponseEntity<CinemaHall> saveCinema(@RequestBody CinemaHall cinemaHall){
        return new ResponseEntity<CinemaHall>(cinemaHallService.saveCinemaHall(cinemaHall), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CinemaHall> getAllCinemaHalls(){
        return cinemaHallService.getAllCinemaHalls();
    }

    @GetMapping("{id}")
    public ResponseEntity<CinemaHall> getCinemaHallById(@PathVariable("id") long cinemaId){
        return new ResponseEntity<CinemaHall>(cinemaHallService.getCinemaHallByID(cinemaId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CinemaHall> updateCinemaHall(@PathVariable("id") long id, @RequestBody CinemaHall cinemaHall){
        return new ResponseEntity<CinemaHall>(cinemaHallService.updateCinemaHall(cinemaHall, id), HttpStatus.OK);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteCinemaHall(@PathVariable("id") long id){
        cinemaHallService.deleteCinemaHall(id);
        return new ResponseEntity<String>("CinemaHall :"+ id + " deleted succesfully!", HttpStatus.OK);
    }
}
