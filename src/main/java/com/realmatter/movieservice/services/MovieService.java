package com.realmatter.movieservice.services;

import com.realmatter.movieservice.model.MovieRecord;

import java.util.List;

public interface MovieService {

  List<MovieRecord> getMovieRecords(String sortBy);
}
