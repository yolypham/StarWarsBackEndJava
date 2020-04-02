package com.realmatter.movieservice.model;

import javax.persistence.*;

@Entity
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "userid")
  private String userId;
  private String favorite_imdbID;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setUserid(String userid) {
    this.userId = userId;
  }

  public String getFavorite_imdbID() {
    return favorite_imdbID;
  }

  public void setFavorite_imdbID(String favorite_imdbID) {
    this.favorite_imdbID = favorite_imdbID;
  }

  @Override
  public String toString() {
    return "Favorite{" +
            "id=" + id +
            ", userId='" + userId + '\'' +
            ", favorite_imdbID='" + favorite_imdbID + '\'' +
            '}';
  }
}
