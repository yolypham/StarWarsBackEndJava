package com.realmatter.movieservice.services;

import com.realmatter.movieservice.model.Favorite;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {

  Favorite addFavorite(Favorite favorite);

  void removeFavorite(Long id);

  List<Favorite> getFavoriteByUserId(String userId);

  Optional<Favorite> getFavoriteById(Long id);
}
