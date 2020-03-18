package com.realmatter.movieservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {
  @JsonProperty("episode")
  private int episode;

  @JsonProperty("release")
  private int release;

  @JsonProperty("machete")
  private int machete;

  @JsonProperty("episode")
  public int getEpisode() {
    return episode;
  }

  @JsonProperty("episode")
  public void setEpisode(int episode) {
    this.episode = episode;
  }

  @JsonProperty("release")
  public int getRelease() {
    return release;
  }

  @JsonProperty("release")
  public void setRelease(int release) {
    this.release = release;
  }

  @JsonProperty("machete")
  public int getMachete() {
    return machete;
  }

  @JsonProperty("machete")
  public void setMachete(int machete) {
    this.machete = machete;
  }
}
