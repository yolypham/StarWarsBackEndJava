package com.realmatter.movieservice.controller;

import com.realmatter.movieservice.model.Favorite;
import com.realmatter.movieservice.services.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class FavoriteController {

  @Autowired private FavoriteServiceImpl favoriteService;

  @GetMapping("/favorite/user")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<Favorite>> getFavoriteByUserid(@RequestParam String userId) {
    List<Favorite> favorites = favoriteService.getFavoriteByUserId(userId);
    return new ResponseEntity<>(favorites, HttpStatus.OK);
  }

  @PostMapping("/favorite/add")
  @ResponseStatus(value = HttpStatus.CREATED)
  public ResponseEntity<?> addFavorite(@RequestBody Favorite favorite) {
    favoriteService.addFavorite(favorite);
    return new ResponseEntity<>(favorite, HttpStatus.CREATED);
  }

  @DeleteMapping("/favorite/remove")
  @ResponseStatus(value = HttpStatus.OK)
  public void removeFavorite(@RequestParam Long id) {
    favoriteService.removeFavorite(id);
  }

  @GetMapping("/favorite")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<?> getFavoriteById(@RequestParam Long id) {
    Optional<Favorite> favorite = favoriteService.getFavoriteById(id);
    return new ResponseEntity<>(favorite, HttpStatus.OK);
  }
}
