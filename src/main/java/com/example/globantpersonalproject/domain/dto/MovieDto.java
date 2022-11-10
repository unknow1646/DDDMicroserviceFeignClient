package com.example.globantpersonalproject.domain.dto;

import com.example.globantpersonalproject.domain.entities.Rating;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDto {
  public String title;
  public String year;
  public String rated;
    public List<RatingMovieDto> ratingList = new ArrayList<>();

}
