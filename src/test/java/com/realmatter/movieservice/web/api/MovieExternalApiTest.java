package com.realmatter.movieservice.web.api;

import com.realmatter.movieservice.model.Movie;
import com.realmatter.movieservice.model.MovieDetail;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MovieExternalApiTest {

  private static final String MYSTERIOUS_PEAK_URL = "https://mysterious-peak-27876.herokuapp.com/";
  private static final String MOVIE_DETAIL_URL =
      "http://www.omdbapi.com/?i=tt0080684&apikey=57ec2f6d";

  @Test
  public void testGetAllMovies() throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<List<Movie>> response =
        restTemplate.exchange(
            MYSTERIOUS_PEAK_URL,
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<Movie>>() {});

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    //        List<Movie> movies = response.getBody();
  }

  @Test
  public void testGetMovieDetail() throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<MovieDetail> response =
        restTemplate.exchange(
            MOVIE_DETAIL_URL,
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<MovieDetail>() {});

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    //    MovieDetail movieDetail = response.getBody();
  }
}
