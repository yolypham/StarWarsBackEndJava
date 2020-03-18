package com.realmatter.movieservice.controller;

import com.realmatter.movieservice.model.User;
import com.realmatter.movieservice.repos.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
  @Autowired private UserCrudRepository userCrudRepository;

  @GetMapping("/user")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = (List<User>) userCrudRepository.findAll();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
}
