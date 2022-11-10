package com.example.globantpersonalproject.infrastructure.rest;

import com.example.globantpersonalproject.application.service.ServiceRepository;
import com.example.globantpersonalproject.application.service.impl.JsonKafkaProducer;
import com.example.globantpersonalproject.domain.entities.Movie;
import com.example.globantpersonalproject.infrastructure.restclient.FeignServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class FeignController {

    @Autowired
    FeignServiceClient feignInterfaceBla;

    @Autowired
    public FeignController(JsonKafkaProducer jsonKafkaProducer,
        ServiceRepository serviceRepository) {
        this.jsonKafkaProducer = jsonKafkaProducer;
        this.serviceRepository = serviceRepository;
    }

    JsonKafkaProducer jsonKafkaProducer;
    ServiceRepository serviceRepository;



    @GetMapping("/movie")
    public Object getMovie(@RequestParam("t") String movieName) throws JsonProcessingException {
         //url = "?t=Batman&apiKey=5ce0471d";
        String apiKey = "5ce0471d";
        Object object = feignInterfaceBla.getObject(movieName, apiKey);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(object);
        Movie movie = objectMapper.readValue(s, Movie.class);
        serviceRepository.create(movie);
        jsonKafkaProducer.sendMessage(movie);
        return feignInterfaceBla.getObject(movieName, apiKey);
    }


    @GetMapping("/movieTitle")
    public Object getMovieByMovieTittle(@RequestParam("t") String movieTitle) {
        return serviceRepository.getMovie(movieTitle);
    }
}
