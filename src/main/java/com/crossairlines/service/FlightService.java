package com.crossairlines.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossairlines.dto.FlightRequestDto;
import com.crossairlines.dto.FlightResponseDto;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.repository.FlightRepository;

@Service
@Transactional
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public FlightResponseDto addFlight(FlightRequestDto flightRequestDto) {
        FlightDetails flightDetails = new FlightDetails();
        
        // Copy properties from DTO to entity
        flightDetails.setFlightDetailsId(flightRequestDto.getFlightDetailsId());
        flightDetails.setFromCountry(flightRequestDto.getFromCountry());
        flightDetails.setDestCountry(flightRequestDto.getDestCountry());
        flightDetails.setOriginCity(flightRequestDto.getOriginCity());
        flightDetails.setDestinationCity(flightRequestDto.getDestinationCity());
        flightDetails.setOriginAirport(flightRequestDto.getOriginAirport());
        flightDetails.setDestinationAirport(flightRequestDto.getDestinationAirport());
        
        // Handle date parsing for departure date
        if (flightRequestDto.getDepartDatet() != null) {
            try {
                Date departDate = new SimpleDateFormat("yyyy-MM-dd").parse(flightRequestDto.getDepartDatet());
                flightDetails.setDepartDate(departDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        flightDetails.setDepartTime(flightRequestDto.getDepartTime());
        
        // Handle date parsing for arrival date
        if (flightRequestDto.getArrivalDatet() != null) {
            try {
                Date arrivalDate = new SimpleDateFormat("yyyy-MM-dd").parse(flightRequestDto.getArrivalDatet());
                flightDetails.setArrivalDate(arrivalDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        flightDetails.setArrivalTime(flightRequestDto.getArrivalTime());
        flightDetails.setEconomyFare(flightRequestDto.getEconomyFare());
        flightDetails.setBusinessFare(flightRequestDto.getBusinessFare());
        flightDetails.setFirstClassFare(flightRequestDto.getFirstClassFare());
        flightDetails.setCompany(flightRequestDto.getCompany());
        flightDetails.setFlightType(flightRequestDto.getFlightType());
        flightDetails.setTimeTaken(flightRequestDto.getTimeTaken());
        flightDetails.setSeatsAvailabe(flightRequestDto.getSeatsAvailabe());
        
        // Save the flight details
        FlightDetails savedFlight = flightRepository.save(flightDetails);
        
        // Create response
        FlightResponseDto response = new FlightResponseDto();
        response.setFlightDetailsId(savedFlight.getFlightDetailsId());
        response.setFromCountry(savedFlight.getFromCountry());
        response.setDestCountry(savedFlight.getDestCountry());
        response.setOriginCity(savedFlight.getOriginCity());
        response.setDestinationCity(savedFlight.getDestinationCity());
        response.setOriginAirport(savedFlight.getOriginAirport());
        response.setDestinationAirport(savedFlight.getDestinationAirport());
        response.setDepartDate(savedFlight.getDepartDate());
        response.setDepartTime(savedFlight.getDepartTime());
        response.setArrivalDate(savedFlight.getArrivalDate());
        response.setArrivalTime(savedFlight.getArrivalTime());
        response.setEconomyFare(savedFlight.getEconomyFare());
        response.setBusinessFare(savedFlight.getBusinessFare());
        response.setFirstClassFare(savedFlight.getFirstClassFare());
        response.setCompany(savedFlight.getCompany());
        response.setFlightType(savedFlight.getFlightType());
        response.setTimeTaken(savedFlight.getTimeTaken());
        response.setSeatsAvailabe(savedFlight.getSeatsAvailabe());
        response.setMessage("Flight added successfully");
        response.setStatus("SUCCESS");
        
        return response;
    }
}