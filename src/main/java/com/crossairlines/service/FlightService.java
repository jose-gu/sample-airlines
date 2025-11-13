package com.crossairlines.service;

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

    public FlightResponseDto addFlight(FlightRequestDto flightRequest) {
        System.out.println(flightRequest);
        
        FlightDetails flightDetails = new FlightDetails();
        
        // Copy properties from DTO to entity
        flightDetails.setFlightDetailsId(flightRequest.getFlightDetailsId());
        flightDetails.setFromCountry(flightRequest.getFromCountry());
        flightDetails.setDestCountry(flightRequest.getDestCountry());
        flightDetails.setOriginCity(flightRequest.getOriginCity());
        flightDetails.setDestinationCity(flightRequest.getDestinationCity());
        flightDetails.setOriginAirport(flightRequest.getOriginAirport());
        flightDetails.setDestinationAirport(flightRequest.getDestinationAirport());
        flightDetails.setDepartDate(flightRequest.getDepartDate());
        flightDetails.setDepartTime(flightRequest.getDepartTime());
        flightDetails.setArrivalDate(flightRequest.getArrivalDate());
        flightDetails.setArrivalTime(flightRequest.getArrivalTime());
        flightDetails.setEconomyFare(flightRequest.getEconomyFare());
        flightDetails.setBusinessFare(flightRequest.getBusinessFare());
        flightDetails.setFirstClassFare(flightRequest.getFirstClassFare());
        flightDetails.setCompany(flightRequest.getCompany());
        flightDetails.setFlightType(flightRequest.getFlightType());
        flightDetails.setTimeTaken(flightRequest.getTimeTaken());
        flightDetails.setSeatsAvailabe(flightRequest.getSeatsAvailabe());
        
        System.out.println(flightDetails);
        
        FlightDetails savedFlight = flightRepository.save(flightDetails);
        
        FlightResponseDto response = new FlightResponseDto();
        response.setMessage("Flight added successfully");
        response.setFlightId(savedFlight.getFlightDetailsId());
        response.setSuccess(true);
        
        return response;
    }
}