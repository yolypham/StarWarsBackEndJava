package com.realmatter.movieservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieRecord {

  @JsonProperty("imdbId")
  private String imdbId;
  @JsonProperty("Title")
  private String title;
  @JsonProperty("Actors")
  private String actors;
  @JsonProperty("coverArtImageUrl")
  private String coverArtImageUrl;
  @JsonProperty("Story")
  private int story;
  @JsonProperty("Machete")
  private int machete;

  public String getImdbId() {
    return imdbId;
  }

  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  public int getStory() {
    return story;
  }

  public void setStory(int story) {
    this.story = story;
  }

  public int getMachete() {
    return machete;
  }

  public void setMachete(int machete) {
    this.machete = machete;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getActors() {
    return actors;
  }

  public void setActors(String actors) {
    this.actors = actors;
  }

  public String getCoverArtImageUrl() {
    return coverArtImageUrl;
  }

  public void setCoverArtImageUrl(String coverArtImageUrl) {
    this.coverArtImageUrl = coverArtImageUrl;
  }
}
