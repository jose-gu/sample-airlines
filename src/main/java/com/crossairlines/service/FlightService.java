package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.repository.FlightRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void addFlight(FlightDto flightDto) {
        FlightDetails flightDetails = mapToEntity(flightDto);
        flightRepository.save(flightDetails);
    }

    private FlightDetails mapToEntity(FlightDto flightDto) {
        FlightDetails flightDetails = new FlightDetails();
        
        flightDetails.setFlightDetailsId(flightDto.getFlightDetailsId());
        flightDetails.setFromCountry(flightDto.getFromCountry());
        flightDetails.setDestCountry(flightDto.getDestCountry());
        flightDetails.setOriginCity(flightDto.getOriginCity());
        flightDetails.setDestinationCity(flightDto.getDestinationCity());
        flightDetails.setOriginAirport(flightDto.getOriginAirport());
        flightDetails.setDestinationAirport(flightDto.getDestinationAirport());
        
        // Handle date parsing for departure date
        if (flightDto.getDepartDatet() != null && !flightDto.getDepartDatet().isEmpty()) {
            try {
                flightDetails.setDepartDate(new SimpleDateFormat("yyyy-MM-dd").parse(flightDto.getDepartDatet()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        // Handle date parsing for arrival date
        if (flightDto.getArrivalDatet() != null && !flightDto.getArrivalDatet().isEmpty()) {
            try {
                flightDetails.setArrivalDate(new SimpleDateFormat("yyyy-MM-dd").parse(flightDto.getArrivalDatet()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        flightDetails.setDepartTime(flightDto.getDepartTime());
        flightDetails.setArrivalTime(flightDto.getArrivalTime());
        flightDetails.setEconomyFare(flightDto.getEconomyFare());
        flightDetails.setBusinessFare(flightDto.getBusinessFare());
        flightDetails.setFirstClassFare(flightDto.getFirstClassFare());
        flightDetails.setCompany(flightDto.getCompany());
        flightDetails.setFlightType(flightDto.getFlightType());
        flightDetails.setTimeTaken(flightDto.getTimeTaken());
        flightDetails.setSeatsAvailabe(flightDto.getSeatsAvailabe());
        
        return flightDetails;
    }
}