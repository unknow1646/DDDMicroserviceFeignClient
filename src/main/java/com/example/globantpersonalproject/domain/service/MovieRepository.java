package com.example.globantpersonalproject.domain.service;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import java.util.List;

public interface MovieRepository {

  MovieDto getMovie(String movieTitlle);

  List<MovieDto> getAllMovies();

}
