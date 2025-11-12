package com.crossairlines.repository;

import com.crossairlines.model.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightDetails, Integer> {
    
    List<FlightDetails> findByOriginCityAndDestinationCity(String originCity, String destinationCity);
    
    List<FlightDetails> findByDepartDateBetween(Date startDate, Date endDate);
    
    List<FlightDetails> findByCompany(String company);
    
    @Query("SELECT f FROM FlightDetails f WHERE f.seatsAvailable > 0 AND f.departDate >= CURRENT_DATE")
    List<FlightDetails> findActiveFlights();
    
    @Query("SELECT f FROM FlightDetails f WHERE f.originCity = :originCity AND f.destinationCity = :destinationCity AND f.departDate = :departDate")
    List<FlightDetails> findFlightsByRouteAndDate(@Param("originCity") String originCity, 
                                                  @Param("destinationCity") String destinationCity, 
                                                  @Param("departDate") Date departDate);
    
    @Query("SELECT f FROM FlightDetails f WHERE f.flightType = :flightType")
    List<FlightDetails> findByFlightType(@Param("flightType") String flightType);
}