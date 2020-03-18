package com.realmatter.movieservice.repos;

import com.realmatter.movieservice.model.RequestHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class CustomTraceRepository implements HttpTraceRepository {

  @Autowired RequestHistoryRepository requestHistoryRepository;

  AtomicReference<HttpTrace> lastTrace = new AtomicReference<>();

  @Override
  public List<HttpTrace> findAll() {
    return Collections.singletonList(lastTrace.get());
  }

  @Override
  public void add(HttpTrace trace) {

    RequestHistory requestHistory = new RequestHistory();
    requestHistory.setRequestorIpAddress(trace.getRequest().getRemoteAddress());
    URI uri = trace.getRequest().getUri();
    requestHistory.setRequestQuery(uri.toString());
    requestHistory.setTimestamp(trace.getTimestamp());
    requestHistoryRepository.save(requestHistory);
    lastTrace.set(trace);
  }
}
