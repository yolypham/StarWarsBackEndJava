package com.realmatter.movieservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
  @JsonProperty("Source")
  private String Source;

  @JsonProperty("Value")
  private String Value;

  @JsonProperty("Source")
  public String getSource() {
    return Source;
  }

  @JsonProperty("Source")
  public void setSource(String source) {
    Source = source;
  }

  @JsonProperty("Value")
  public String getValue() {
    return Value;
  }

  @JsonProperty("Value")
  public void setValue(String value) {
    Value = value;
  }
}
