package com.example.globantpersonalproject.domain.service.impl;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.entities.Movie;
import com.example.globantpersonalproject.domain.mapper.MovieConverter;
import com.example.globantpersonalproject.domain.service.MovieRepository;
import com.example.globantpersonalproject.infrastructure.repositories.MovieDataRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Copyright 2021 MonetaGo, Inc. All Rights Reserved.
 *
 * This code is copyrighted material that is confidential and proprietary to MonetaGo, Inc.
 * and may not (in whole or in part) be published, publicly displayed, copied, modified or
 * used in any way other than as expressly permitted in a written agreement executed by
 * MonetaGo, Inc. No portion of this code may be used to create derivative works or exploited
 * in any other way without MonetaGo, Inc.'s prior written consent. No portion of this code
 * may be transmitted or redistributed to any person without MonetaGo, Inc.'s prior written
 * consent. This notice may not be deleted or modified without MonetaGo, Inc.'s consent.
 */

@Service
public class Serviceimpl implements MovieRepository {

  MovieDataRepository movieDataRepository;
  MovieConverter converterMovie;

  @Autowired
  public Serviceimpl(MovieDataRepository movieDataRepository, MovieConverter converterMovie) {
    this.movieDataRepository = movieDataRepository;
    this.converterMovie = converterMovie;
  }

  @Override
  public MovieDto getMovie(String movieTitle) {
    Optional<Movie> movie = movieDataRepository.findByTitle(movieTitle);
    return converterMovie.convert(movie);
  }

  @Override
  public List<MovieDto> getAllMovies() {

    List<Movie> allMovies = movieDataRepository.findAll();
    return allMovies
        .stream()
        .map(movie -> converterMovie.convert(Optional.ofNullable(movie)))
        .collect(Collectors.toList());
  }


}
