package com.realmatter.movieservice.repos;

import com.realmatter.movieservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, String> {}
