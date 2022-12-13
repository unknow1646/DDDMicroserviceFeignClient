package com.example.globantpersonalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@EnableConfigurationProperties(KafkaProperties.class)
@SpringBootApplication(exclude = {KafkaAutoConfiguration.class})
@EnableFeignClients
@PropertySource(name = "myProperties", value = "application.properties")public class GlobantpersonalprojectApplication {

  public static void main(String[] args) {

    SpringApplication.run(GlobantpersonalprojectApplication.class, args);

  }

}
