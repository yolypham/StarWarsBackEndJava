package com.realmatter.movieservice.web.api;

import com.realmatter.movieservice.model.Favorite;
import com.realmatter.movieservice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FavoriteControllerTest {

  private static final String API_URL = "http://localhost:8080/api";

  @Test
  public void testGetAllUsers() throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<List<User>> response =
        restTemplate.exchange(
            API_URL + "/user",
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<User>>() {});

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    List<User> users = response.getBody();
  }

  @Test
  public void testGetFavoritesByUserid() throws Exception {
    String userId = "guest";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<List<Favorite>> response =
        restTemplate.exchange(
            API_URL + "/favorite/user?userId=" + userId,
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<Favorite>>() {});

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    List<Favorite> favorites = response.getBody();
  }

  @Test
  public void testAddFavorite() throws Exception {

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    String userId = "guest";
    String imdbId = "favorite123";

    String body = "{\"userId\":\"" + userId + "\",\"favorite_imdbID\":\"" + imdbId + "\"}";
    HttpEntity<?> httpEntity = new HttpEntity<>(body, headers);
    ResponseEntity<Favorite> response =
        restTemplate.exchange(
            API_URL + "/favorite/add", HttpMethod.POST, httpEntity, Favorite.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
    Favorite favorites = response.getBody();
  }

  @Test
  public void testDeleteFavoriteById() throws Exception {
    long id = 5;

    RestTemplate restTemplate = new RestTemplate();

    restTemplate.delete(API_URL + "/favorite/remove?id=" + id);
  }

  @Test
  public void testGetFavoriteById() throws Exception {
    long id = 5;

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<Favorite> response =
        restTemplate.exchange(
            API_URL + "/favorite?id=" + id, HttpMethod.GET, httpEntity, Favorite.class);

    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    Favorite favorites = response.getBody();
  }
}
