package com.example.globantpersonalproject.domain.service.impl;

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

import com.example.globantpersonalproject.domain.entities.Movie;
import com.example.globantpersonalproject.domain.service.MovieProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MovieProducerImpl implements MovieProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(MovieProducerImpl.class);
  private final KafkaTemplate<String, Movie> userKafkaTemplate;

  @Autowired
  public MovieProducerImpl(
      KafkaTemplate<String, Movie> kafkaTemplate) {
    this.userKafkaTemplate = kafkaTemplate;
  }

  @Override
  public void sendMessage(Movie movie) {

    LOGGER.info(String.format("MESSAGE SENT -> %S ", movie.toString()));

    Message<Movie> userMessage = MessageBuilder.withPayload(movie)
        .setHeader(KafkaHeaders.TOPIC, "java").build();
    userKafkaTemplate.send(userMessage);
  }
}
