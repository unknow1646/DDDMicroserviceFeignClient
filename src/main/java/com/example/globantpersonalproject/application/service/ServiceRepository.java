package com.example.globantpersonalproject.application.service;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.entities.Movie;

public interface ServiceRepository {

  void create(Movie user);

  MovieDto getMovie(String movieTitlle);

}
