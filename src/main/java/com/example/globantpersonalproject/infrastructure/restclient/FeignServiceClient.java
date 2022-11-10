package com.example.globantpersonalproject.infrastructure.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "feignDemo", url = "http://www.omdbapi.com/")
public interface FeignServiceClient {

    @RequestMapping( method = RequestMethod.GET)
    Object getObject(@RequestParam String t,  @RequestParam String apiKey);
}
