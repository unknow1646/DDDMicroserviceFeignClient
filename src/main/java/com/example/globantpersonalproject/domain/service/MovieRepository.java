package com.example.globantpersonalproject.domain.service;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import java.util.List;

public interface MovieRepository {

  List<MovieDto> getAllMovies();

}
