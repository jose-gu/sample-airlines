package com.crossairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.model.User;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightAndUserRepository {
    
    // Flight repository methods
    interface FlightRepository extends JpaRepository<FlightDetails, Integer> {
        
        List<FlightDetails> findByOriginCityAndDestinationCity(String originCity, String destinationCity);
        
        List<FlightDetails> findByOriginCityAndDestinationCityAndDepartDate(String originCity, String destinationCity, Date departDate);
        
        @Query("SELECT fd FROM FlightDetails fd WHERE fd.originCity = :originCity AND fd.destinationCity = :destinationCity")
        List<FlightDetails> findFlightsByRoute(@Param("originCity") String originCity, @Param("destinationCity") String destinationCity);
        
        Optional<FlightDetails> findById(Integer id);
        
        @Query("SELECT f FROM FlightDetails f WHERE f.flightDetailsId = :id")
        FlightDetails findFlightDetails(@Param("id") Integer id);
        
        List<FlightDetails> findAll();
    }
    
    // User repository methods
    interface UserRepository extends JpaRepository<User, Integer> {
        
        Optional<User> findById(Integer userId);
        
        @Query("SELECT u FROM User u WHERE u.loginId = :loginId")
        User findByLoginId(@Param("loginId") String loginId);
        
        @Query("SELECT u FROM User u WHERE u.loginId = :loginId")
        User validateUser(@Param("loginId") String loginId);
    }
}