package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

}
