package com.crossairlines.repository;

import com.crossairlines.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
    
    List<Airport> findByOriginCity(String originCity);
    
    List<Airport> findByDestCity(String destCity);
    
    boolean existsByOriginCityAndDestCity(String originCity, String destCity);
}