package com.realmatter.movieservice.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class RequestHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "request_query")
  private String requestQuery;

  @Column(name = "requestor_ip_address")
  private String requestorIpAddress;

  @Column(name = "timestamp")
  private Instant timestamp;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRequestorIpAddress() {
    return requestorIpAddress;
  }

  public void setRequestorIpAddress(String requestorIpAddress) {
    this.requestorIpAddress = requestorIpAddress;
  }

  public String getRequestQuery() {
    return requestQuery;
  }

  public void setRequestQuery(String requestQuery) {
    this.requestQuery = requestQuery;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }
}
