package com.crossairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crossairlines.model.FlightDetails;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightDetails, Integer> {
    
    List<FlightDetails> findByOriginCityAndDestinationCity(String originCity, String destinationCity);
}