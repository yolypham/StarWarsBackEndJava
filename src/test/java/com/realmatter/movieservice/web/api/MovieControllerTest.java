package com.realmatter.movieservice.web.api;

import com.realmatter.movieservice.model.MovieRecord;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MovieControllerTest {

  private static final String MOVIE_URL = "http://localhost:8080/api";

  @Test
  public void testGetMoviesSortByStory() throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<List<MovieRecord>> response =
        restTemplate.exchange(
            MOVIE_URL + "/movie?sortBy=STORY",
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<MovieRecord>>() {});

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//    List<MovieRecord> movies = response.getBody();
  }

  @Test
  public void testGetMoviesSortByMachete() throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<List<MovieRecord>> response =
        restTemplate.exchange(
            MOVIE_URL + "/movie?sortBy=MACHETE",
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<MovieRecord>>() {});

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//    List<MovieRecord> movies = response.getBody();
  }
}
