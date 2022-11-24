package com.example.globantpersonalproject.infrastructure.configuration.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Bean
  public NewTopic javaGuidesTopic() {
    return TopicBuilder.name("javaguides")
        .build();
  }

  @Bean
  public NewTopic javaTopic() {
    return TopicBuilder.name("java")
        .build();
  }
}
