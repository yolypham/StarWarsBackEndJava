package com.realmatter.movieservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

  @JsonProperty("imdbId")
  private String imdbId;

  @JsonProperty("position")
  private Position position;
  
  public String getImdbId() {
    return imdbId;
  }

  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {

    this.position = position;
  }
}
