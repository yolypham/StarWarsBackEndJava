package com.realmatter.movieservice.services;

import com.realmatter.movieservice.config.MovieConfig;
import com.realmatter.movieservice.model.Movie;
import com.realmatter.movieservice.model.MovieDetail;
import com.realmatter.movieservice.model.MovieRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

  private final MovieConfig movieConfig;

  @Autowired
  public MovieServiceImpl(MovieConfig movieConfig) {
    this.movieConfig = movieConfig;
  }

  private List<Movie> getMovies() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<List<Movie>> response =
        restTemplate.exchange(
            movieConfig.getMysteriousPeakUrl(),
            HttpMethod.GET,
            httpEntity,
            new ParameterizedTypeReference<List<Movie>>() {});

    List<Movie> movies = response.getBody();
    return movies;
  }

  private MovieDetail getMovieDetail(String id) {
    String url =
        movieConfig.getOmdbApiUrl() + "?i=" + id + "&apikey=" + movieConfig.getOmdbApiKey();
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    ResponseEntity<MovieDetail> response =
        restTemplate.exchange(
            url, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<MovieDetail>() {});

    MovieDetail movieDetail = response.getBody();
    return movieDetail;
  }

  @Override
  public List<MovieRecord> getMovieRecords(String sortBy) {
    List<Movie> movies = getMovies();

    List<MovieRecord> movieRecords =
        movies.stream()
            .map(
                m -> {
                  MovieRecord movieRecord = new MovieRecord();
                  MovieDetail movieDetail = getMovieDetail(m.getImdbId());

                  movieRecord.setImdbId(m.getImdbId());
                  movieRecord.setTitle(movieDetail.getTitle());
                  movieRecord.setActors(movieDetail.getActors());
                  movieRecord.setStory(m.getPosition().getEpisode());
                  movieRecord.setMachete(m.getPosition().getMachete());
                  movieRecord.setCoverArtImageUrl(
                      movieConfig.getOmdbApiImg()
                          + "?i="
                          + m.getImdbId()
                          + "&apikey="
                          + movieConfig.getOmdbApiKey());
                  return movieRecord;
                })
            .filter(
                m ->
                    sortBy.equals(SORTBY.STORY.name())
                        || (sortBy.equals(SORTBY.MACHETE.name()) && m.getMachete() > 0))
            .sorted(
                sortBy.equals(SORTBY.STORY.name())
                    ? Comparator.comparingInt(MovieRecord::getStory)
                    : Comparator.comparingInt(MovieRecord::getMachete))
            .collect(Collectors.toList());

    return movieRecords;
  }

  public enum SORTBY {
    STORY,
    MACHETE
  }
}
