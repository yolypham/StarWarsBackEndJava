package com.realmatter.movieservice.services;

import com.realmatter.movieservice.model.Favorite;
import com.realmatter.movieservice.repos.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

  @Autowired private FavoriteRepository favoriteRepository;

  @Override
  public Favorite addFavorite(Favorite favorite) {
    favoriteRepository.save(favorite);
    return favorite;
  }

  @Override
  public void removeFavorite(Long id) {
    favoriteRepository.deleteById(id);
  }

  @Override
  public List<Favorite> getFavoriteByUserId(String userId) {
    return favoriteRepository.findByUserId(userId);
  }

  @Override
  public Optional<Favorite> getFavoriteById(Long id) {
    return favoriteRepository.findById(id);
  }
}
