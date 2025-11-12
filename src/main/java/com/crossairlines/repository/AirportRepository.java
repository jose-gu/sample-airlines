package com.crossairlines.repository;

import com.crossairlines.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    @Query("SELECT a FROM Airport a WHERE a.originCity = :originCity AND a.destinationCity = :destinationCity")
    List<Airport> findByOriginCityAndDestinationCity(@Param("originCity") String originCity, @Param("destinationCity") String destinationCity);
}