package com.example.globantpersonalproject.domain.service.impl;

import com.example.globantpersonalproject.infrastructure.repositories.MovieDataRepository;
import com.example.globantpersonalproject.domain.entities.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
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
public class MovieConsumerImpl {

  private static final Logger LOGGER = LoggerFactory.getLogger(MovieConsumerImpl.class);

  MovieDataRepository movieDataRepository;

  @Autowired
  public MovieConsumerImpl(MovieDataRepository movieDataRepository) {
    this.movieDataRepository = movieDataRepository;
  }

  @KafkaListener(topics = "java", groupId = "myGroup")
  public void consume(Movie movie) {

    LOGGER.info(String.format("MESSAGE RECiEVED -> %S ", movie.toString()));

  }
}
