package com.crossairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crossairlines.model.Flight;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    
    Optional<Flight> findById(int flightId);
    
    @Query("SELECT f FROM Flight f WHERE f.flightId = :flightId AND f.seatsAvailable > 0")
    Optional<Flight> findByIdAndAvailable(@Param("flightId") int flightId);
    
    List<Flight> findByOriginCityAndDestinationCity(String originCity, String destinationCity);
    
    @Query("SELECT f FROM Flight f WHERE f.originCity = :origin AND f.destinationCity = :destination")
    List<Flight> findByOriginAndDestination(@Param("origin") String origin, @Param("destination") String destination);
}