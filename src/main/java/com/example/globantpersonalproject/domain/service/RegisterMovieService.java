package com.example.globantpersonalproject.domain.service;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RegisterMovieService {

 // MovieDto registerMovie(String movie) throws JsonProcessingException;
  MovieDto registerRedisMovie(String movie) throws JsonProcessingException;

}
