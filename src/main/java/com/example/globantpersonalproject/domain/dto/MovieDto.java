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
