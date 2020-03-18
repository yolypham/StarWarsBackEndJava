package com.realmatter.movieservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {

  @Value("${mysterious.peak.url}")
  private String mysteriousPeakUrl;

  @Value("${omdbapi.url}")
  private String omdbApiUrl;

  @Value("${omdbapi.img}")
  private String omdbApiImg;

  @Value("${omdbapi.key}")
  private String omdbApiKey;

  public String getOmdbApiImg() {
    return omdbApiImg;
  }

  public String getMysteriousPeakUrl() {
    return mysteriousPeakUrl;
  }

  public String getOmdbApiUrl() {
    return omdbApiUrl;
  }

  public String getOmdbApiKey() {
    return omdbApiKey;
  }
}
