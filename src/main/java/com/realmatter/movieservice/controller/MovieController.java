package com.realmatter.movieservice.controller;

import com.realmatter.movieservice.model.MovieRecord;
import com.realmatter.movieservice.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

  @Autowired private MovieServiceImpl movieService;

  @GetMapping("/movie")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<MovieRecord>> getMovieRecords(@RequestParam String sortBy) {
    List<MovieRecord> movieRecords = movieService.getMovieRecords(sortBy);
    return new ResponseEntity<>(movieRecords, HttpStatus.OK);
  }
}
