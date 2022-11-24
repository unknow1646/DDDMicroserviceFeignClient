package com.example.globantpersonalproject.application.rest;

import com.example.globantpersonalproject.domain.service.MovieRepository;
import com.example.globantpersonalproject.domain.service.RegisterMovieService;
import com.example.globantpersonalproject.domain.service.impl.MovieProducerImpl;
import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.entities.Movie;
import com.example.globantpersonalproject.infrastructure.restclient.FeignServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

  MovieProducerImpl movieProducerImpl;

  MovieRepository movieRepository;

  @Autowired
  public FeignController(MovieProducerImpl movieProducerImpl,
      MovieRepository movieRepository, RegisterMovieService registerMovieService) {
    this.movieProducerImpl = movieProducerImpl;
    this.movieRepository = movieRepository;
    this.registerMovieService = registerMovieService;
  }

  @GetMapping("/movie")
  public ResponseEntity<MovieDto> getMovie(@RequestParam("t") String movieName) throws JsonProcessingException {

    MovieDto movieDto = registerMovieService.registerMovie(movieName);
    return ResponseEntity.status(HttpStatus.OK).body(movieDto);

  }

  @GetMapping("/movieTitle")
  public Object getMovieByMovieTittle(@RequestParam("t") String movieTitle) {
    return movieRepository.getMovie(movieTitle);
  }

  @GetMapping
  public List<MovieDto> getAllMovies() {
    return movieRepository.getAllMovies();
  }
}
