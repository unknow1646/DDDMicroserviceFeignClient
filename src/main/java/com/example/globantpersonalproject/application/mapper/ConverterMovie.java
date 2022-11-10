package com.example.globantpersonalproject.application.mapper;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.dto.RatingMovieDto;
import com.example.globantpersonalproject.domain.entities.Movie;
import com.example.globantpersonalproject.domain.entities.Rating;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ConverterMovie implements Converter<Optional<Movie>, MovieDto> {

  @Override
  public MovieDto convert(Optional<Movie> movie) {
    return movie.map(movie1 -> MovieDto.builder()
        .title(movie1.getTitle())
        .year(movie1.getYear())
        .rated(movie1.getRated())
        .ratingList(mapRatingList(movie1))
        .build())
        .orElseThrow();
  }

  private List<RatingMovieDto> mapRatingList(Movie movie){
    return Optional.ofNullable(movie)
        .map(Movie::getRatingList).stream()
        .flatMap(Collection::parallelStream)
        .collect(Collectors.toList())
        .stream()
        .map(rating -> RatingMovieDto.builder()
            .value(rating.getValue())
            .source(rating.getSource())
            .build())
        .collect(Collectors.toList());
  }


}