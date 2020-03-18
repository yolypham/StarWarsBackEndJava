package com.realmatter.movieservice.repos;

import com.realmatter.movieservice.model.Favorite;
import com.realmatter.movieservice.model.RequestHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestHistoryRepository extends JpaRepository<RequestHistory, Long>, JpaSpecificationExecutor<RequestHistory> {
}