package com.example.globantpersonalproject.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MovieEntity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {

  private static final long serialVersionUID = 2675048832069117586L;

  @Column(nullable = false)
  private String movieId;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  @JsonProperty("Title")
  public String title;
  @Column(nullable = false)
  @JsonProperty("Year")
  public String year;
  @Column(nullable = false)
  @JsonProperty("Rated")
  public String rated;
  @Column(nullable = false)
  @JsonProperty("Released")
  public String released;
  @Column(nullable = false)
  @JsonProperty("Runtime")
  public String runtime;
  @Column(nullable = false)
  @JsonProperty("Genre")
  public String genre;
  @Column(nullable = false)
  @JsonProperty("Director")
  public String director;
  @Column(nullable = false)
  @JsonProperty("Writer")
  public String writer;
  @Column(nullable = false)
  @JsonProperty("Actors")
  public String actors;
  @Column(nullable = false)
  @JsonProperty("Plot")
  public String plot;
  @Column(nullable = false)
  @JsonProperty("Language")
  public String language;
  @Column(nullable = false)
  @JsonProperty("Country")
  public String country;
  @Column(nullable = false)
  @JsonProperty("Awards")
  public String awards;
  @Column(nullable = false)
  @JsonProperty("Poster")
  public String poster;
  @Column(nullable = false)
  @JsonProperty("Ratings")
  @OneToMany(fetch = FetchType.LAZY,
      mappedBy = "movie",
      cascade = CascadeType.ALL)
  @JsonManagedReference
  public List<Rating> ratingList = new ArrayList<>();
  @Column(nullable = false)
  @JsonProperty("Metascore")
  public String metascore;
  public String imdbRating;
  public String imdbVotes;
  public String imdbID;
  @Column(nullable = false)
  @JsonProperty("Type")
  public String type;
  @Column(nullable = false)
  @JsonProperty("DVD")
  public String dVD;
  @Column(nullable = false)
  @JsonProperty("BoxOffice")
  public String boxOffice;
  @Column(nullable = false)
  @JsonProperty("Production")
  public String production;
  @Column(nullable = false)
  @JsonProperty("Website")
  public String website;
  @Column(nullable = false)
  @JsonProperty("Response")
  public String response;

  @Override
  public String toString() {
    return "Movie{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", year='" + year + '\'' +
        ", rated='" + rated + '\'' +
        ", released='" + released + '\'' +
        ", runtime='" + runtime + '\'' +
        ", genre='" + genre + '\'' +
        ", director='" + director + '\'' +
        ", writer='" + writer + '\'' +
        ", actors='" + actors + '\'' +
        ", plot='" + plot + '\'' +
        ", language='" + language + '\'' +
        ", country='" + country + '\'' +
        ", awards='" + awards + '\'' +
        ", poster='" + poster + '\'' +
        ", ratingList=" + ratingList +
        ", metascore='" + metascore + '\'' +
        ", imdbRating='" + imdbRating + '\'' +
        ", imdbVotes='" + imdbVotes + '\'' +
        ", imdbID='" + imdbID + '\'' +
        ", type='" + type + '\'' +
        ", dVD='" + dVD + '\'' +
        ", boxOffice='" + boxOffice + '\'' +
        ", production='" + production + '\'' +
        ", website='" + website + '\'' +
        ", response='" + response + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Movie)) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(getId(), movie.getId()) && Objects
        .equals(getTitle(), movie.getTitle()) && Objects.equals(getYear(), movie.getYear())
        && Objects.equals(getRated(), movie.getRated()) && Objects
        .equals(getReleased(), movie.getReleased()) && Objects
        .equals(getRuntime(), movie.getRuntime()) && Objects
        .equals(getGenre(), movie.getGenre()) && Objects
        .equals(getDirector(), movie.getDirector()) && Objects
        .equals(getWriter(), movie.getWriter()) && Objects
        .equals(getActors(), movie.getActors()) && Objects
        .equals(getPlot(), movie.getPlot()) && Objects
        .equals(getLanguage(), movie.getLanguage()) && Objects
        .equals(getCountry(), movie.getCountry()) && Objects
        .equals(getAwards(), movie.getAwards()) && Objects
        .equals(getPoster(), movie.getPoster()) && Objects
        .equals(getRatingList(), movie.getRatingList()) && Objects
        .equals(getMetascore(), movie.getMetascore()) && Objects
        .equals(getImdbRating(), movie.getImdbRating()) && Objects
        .equals(getImdbVotes(), movie.getImdbVotes()) && Objects
        .equals(getImdbID(), movie.getImdbID()) && Objects
        .equals(getType(), movie.getType()) && Objects.equals(getdVD(), movie.getdVD())
        && Objects.equals(getBoxOffice(), movie.getBoxOffice()) && Objects
        .equals(getProduction(), movie.getProduction()) && Objects
        .equals(getWebsite(), movie.getWebsite()) && Objects
        .equals(getResponse(), movie.getResponse());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getId(), getTitle(), getYear(), getRated(), getReleased(), getRuntime(), getGenre(),
            getDirector(), getWriter(), getActors(), getPlot(), getLanguage(), getCountry(),
            getAwards(), getPoster(), getRatingList(), getMetascore(), getImdbRating(),
            getImdbVotes(), getImdbID(), getType(), getdVD(), getBoxOffice(), getProduction(),
            getWebsite(), getResponse());
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getRated() {
    return rated;
  }

  public void setRated(String rated) {
    this.rated = rated;
  }

  public String getReleased() {
    return released;
  }

  public void setReleased(String released) {
    this.released = released;
  }

  public String getRuntime() {
    return runtime;
  }

  public void setRuntime(String runtime) {
    this.runtime = runtime;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getActors() {
    return actors;
  }

  public void setActors(String actors) {
    this.actors = actors;
  }

  public String getPlot() {
    return plot;
  }

  public void setPlot(String plot) {
    this.plot = plot;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }

  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }

  public List<Rating> getRatingList() {
    return ratingList;
  }

  public void setRatingList(List<Rating> ratingList) {
    this.ratingList = ratingList;
    ratingList.forEach(rating -> rating.setMovie(this));
  }

  public String getMetascore() {
    return metascore;
  }

  public void setMetascore(String metascore) {
    this.metascore = metascore;
  }

  public String getImdbRating() {
    return imdbRating;
  }

  public void setImdbRating(String imdbRating) {
    this.imdbRating = imdbRating;
  }

  public String getImdbVotes() {
    return imdbVotes;
  }

  public void setImdbVotes(String imdbVotes) {
    this.imdbVotes = imdbVotes;
  }

  public String getImdbID() {
    return imdbID;
  }

  public void setImdbID(String imdbID) {
    this.imdbID = imdbID;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getdVD() {
    return dVD;
  }

  public void setdVD(String dVD) {
    this.dVD = dVD;
  }

  public String getBoxOffice() {
    return boxOffice;
  }

  public void setBoxOffice(String boxOffice) {
    this.boxOffice = boxOffice;
  }

  public String getProduction() {
    return production;
  }

  public void setProduction(String production) {
    this.production = production;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

}

