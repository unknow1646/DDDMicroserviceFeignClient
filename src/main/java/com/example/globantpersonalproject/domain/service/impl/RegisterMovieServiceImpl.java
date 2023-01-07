package com.example.globantpersonalproject.domain.service.impl;

import com.example.globantpersonalproject.domain.dto.MovieDto;
import com.example.globantpersonalproject.domain.entities.Movie;
import com.example.globantpersonalproject.domain.mapper.MovieConverter;
import com.example.globantpersonalproject.domain.service.MovieProducer;
import com.example.globantpersonalproject.domain.service.RegisterMovieService;
import com.example.globantpersonalproject.infrastructure.repositories.MovieDataRedisRepository;
import com.example.globantpersonalproject.infrastructure.repositories.MovieDataRepository;
import com.example.globantpersonalproject.infrastructure.restclient.FeignServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class RegisterMovieServiceImpl implements RegisterMovieService {

  private static String API_KEY = "5ce0471d";

  //@Value("${token}")
  //private String apiKey;

  @Autowired
  FeignServiceClient feignServiceClient;
  MovieProducer movieProducer;
  MovieConverter movieConverter;
  MovieDataRedisRepository movieDataRedisRepository;

  @Autowired
  public RegisterMovieServiceImpl(MovieProducer movieProducer, MovieDataRepository movieDataRepository,
      MovieConverter movieConverter, MovieDataRedisRepository movieDataRedisRepository) {
    this.movieProducer = movieProducer;
    this.movieConverter = movieConverter;
    this.movieDataRedisRepository = movieDataRedisRepository;
  }

  @Override
  @CacheEvict(value = "movies", allEntries = true)
  public MovieDto registerRedisMovie(String movie) throws JsonProcessingException {

    Object object = feignServiceClient.getObject(movie, API_KEY);
    ObjectMapper objectMapper = new ObjectMapper();
    String s = objectMapper.writeValueAsString(object);
    Movie movie1 = objectMapper.readValue(s, Movie.class);
    movieProducer.sendMessage(movie1);
    movie1.setMovieId("BBB");
    movieDataRedisRepository.save(movie1);
    return movieConverter.convert(Optional.of(movie1));
  }
}
