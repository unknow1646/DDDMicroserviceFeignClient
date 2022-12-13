package com.example.globantpersonalproject.domain.entities.redisentity;

import com.example.globantpersonalproject.domain.entities.Movie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import org.springframework.data.redis.core.RedisHash;
/*
public class RatingRedisEntity {

  private Long id;

  @JsonProperty("Value")
  public String value;


  @JsonProperty("Source")
  public String source;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }



}
*/