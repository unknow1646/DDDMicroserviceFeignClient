package com.example.globantpersonalproject.domain.mapper;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.dto.RatingMovieDto;
import com.example.globantpersonalproject.domain.entities.Movie;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MovieConverter implements Converter<Optional<Movie>, MovieDto> {

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

  private List<RatingMovieDto> mapRatingList(Movie movie) {
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