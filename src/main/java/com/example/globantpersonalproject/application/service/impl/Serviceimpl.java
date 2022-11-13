package com.example.globantpersonalproject.application.service.impl;

import com.example.globantpersonalproject.application.mapper.ConverterMovie;
import com.example.globantpersonalproject.infrastructure.repositories.DataRepository;
import com.example.globantpersonalproject.application.service.ServiceRepository;
import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.entities.Movie;
import java.util.Optional;
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
public class Serviceimpl implements ServiceRepository {

  DataRepository dataRepository;
  ConverterMovie converterMovie;

  @Autowired
  public Serviceimpl(DataRepository dataRepository, ConverterMovie converterMovie) {
    this.dataRepository = dataRepository;
    this.converterMovie = converterMovie;
  }

  @Override
  public void create(Movie user) {

    user.setMovieId("AAAAAAAAAAA");
    dataRepository.save(user);
  }

  @Override
  public MovieDto getMovie(String movieTitle) {
    Optional<Movie> movie = dataRepository.findByTitle(movieTitle);
    return converterMovie.convert(movie);
  }
}
