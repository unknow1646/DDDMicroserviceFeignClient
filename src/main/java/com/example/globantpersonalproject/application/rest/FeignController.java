package com.example.globantpersonalproject.application.rest;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.service.MovieProducer;
import com.example.globantpersonalproject.domain.service.MovieRepository;
import com.example.globantpersonalproject.domain.service.RegisterMovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class FeignController {

  RegisterMovieService registerMovieService;

  MovieProducer movieProducer;

  MovieRepository movieRepository;

  @Autowired
  public FeignController(MovieProducer movieProducer,
      MovieRepository movieRepository, RegisterMovieService registerMovieService) {
    this.movieProducer = movieProducer;
    this.movieRepository = movieRepository;
    this.registerMovieService = registerMovieService;
  }

  @GetMapping("/movie")
  public ResponseEntity<MovieDto> registerMovie(@RequestParam("t") String movieName) throws JsonProcessingException {

    MovieDto movieDto = registerMovieService.registerMovie(movieName);
    return ResponseEntity.status(HttpStatus.OK).body(movieDto);
  }

  @GetMapping("/movieTitle")
  public ResponseEntity<MovieDto> getMovieByMovieTittle(@RequestParam("t") String movieTitle) {
    return ResponseEntity.status(HttpStatus.OK).body(movieRepository.getMovie(movieTitle));
  }

  @GetMapping
  public ResponseEntity<List<MovieDto>> getAllMovies() {
    return ResponseEntity.status(HttpStatus.OK).body(movieRepository.getAllMovies());
  }
}
