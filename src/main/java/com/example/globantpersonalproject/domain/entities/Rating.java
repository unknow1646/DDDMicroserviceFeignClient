package com.example.globantpersonalproject.domain.entities;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RatingMovie")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonProperty("Value")
  @Column(nullable = false)
  public String value;

  @ManyToOne
  @JsonBackReference
  private Movie movie;

  @JsonProperty("Source")
  @Column(nullable = false)
  public String source;

  @Override
  public String toString() {
    return "Rating{" +
        "id=" + id +
        ", value='" + value + '\'' +
        ", movie=" + movie.getId() +
        ", source='" + source + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rating)) {
      return false;
    }
    Rating rating = (Rating) o;
    return Objects.equals(getId(), rating.getId()) && Objects
        .equals(getValue(), rating.getValue()) && Objects
        .equals(getMovie(), rating.getMovie()) && Objects
        .equals(getSource(), rating.getSource());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getValue(), getMovie(), getSource());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


}