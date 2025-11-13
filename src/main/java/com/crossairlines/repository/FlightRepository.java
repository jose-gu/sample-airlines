package com.crossairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crossairlines.model.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {
}