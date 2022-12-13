package com.example.globantpersonalproject.application.rest;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.entities.Movie;
import com.example.globantpersonalproject.domain.service.MovieProducer;
import com.example.globantpersonalproject.domain.service.RegisterMovieService;
import com.example.globantpersonalproject.domain.service.impl.Serviceimpl;
import com.example.globantpersonalproject.infrastructure.repositories.MovieDataRedisRepository;
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

  MovieDataRedisRepository movieDataRedisRepository;

  Serviceimpl serviceimpl;

  @Autowired
  public FeignController(MovieProducer movieProducer,
      MovieDataRedisRepository movieRepository,
      RegisterMovieService registerMovieService,
      Serviceimpl serviceimpl) {
    this.movieProducer = movieProducer;
    this.movieDataRedisRepository = movieRepository;
    this.registerMovieService = registerMovieService;
    this.serviceimpl = serviceimpl;
  }

  @GetMapping("/movie")
  public ResponseEntity<MovieDto> registerMovie(@RequestParam("t") String movieName) throws JsonProcessingException {

    MovieDto movieDto = registerMovieService.registerRedisMovie(movieName);
    return ResponseEntity.status(HttpStatus.OK).body(movieDto);
  }

  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {
    return ResponseEntity.status(HttpStatus.OK).body(movieDataRedisRepository.findAll());
  }

  @GetMapping("/movieRedis")
  public ResponseEntity<MovieDto> registerRedisMovie(@RequestParam("t") String movieName) throws JsonProcessingException {
    return ResponseEntity.status(HttpStatus.OK).body(registerMovieService.registerRedisMovie(movieName));
  }

  @GetMapping("/allMovieRedis")
  public ResponseEntity<List<MovieDto>> getRedisMovie() throws JsonProcessingException {
    return ResponseEntity.status(HttpStatus.OK).body(serviceimpl.getAllMovies());
  }



}
