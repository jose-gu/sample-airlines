package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import com.crossairlines.repository.FlightRepository;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.model.Flight;
import com.crossairlines.dto.request.FlightSearchRequest;
import com.crossairlines.dto.response.FlightSearchResponse;
import com.crossairlines.dto.FlightDetailsDTO;
import com.crossairlines.dto.FlightDetailsDto;
import com.crossairlines.exception.BookingException;
import com.crossairlines.util.DateUtils;

@Service
public class FlightManagementService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight getFlightById(int flightId) {
        return flightRepository.findById(flightId)
                .orElseThrow(() -> new BookingException("Flight not found with id: " + flightId));
    }
    
    public FlightDetails getFlightDetails(Integer flightId) {
        return flightRepository.findById(flightId)
            .orElseThrow(() -> new BookingException("Flight not found with ID: " + flightId));
    }
    
    public boolean validateFlightAvailability(int flightId) {
        FlightDetails flightDetails = getFlightDetails(flightId);
        if (flightDetails == null) {
            return false;
        }
        return flightDetails.getSeatsAvailabe() > 0;
    }
    
    public FlightSearchResponse searchFlights(FlightSearchRequest request) {
        List<FlightDetails> allFlights = flightRepository.findAll();
        List<FlightDetails> matchingFlights = new ArrayList<>();
        List<FlightDetails> alternativeFlights = new ArrayList<>();
        
        categorizeFlights(allFlights, request, matchingFlights, alternativeFlights);
        
        FlightSearchResponse response = new FlightSearchResponse();
        response.setMatchingFlights(convertToDTO(matchingFlights));
        response.setAlternativeFlights(convertToDTO(alternativeFlights));
        
        return response;
    }
    
    private void categorizeFlights(List<FlightDetails> allFlights, FlightSearchRequest request, 
                                 List<FlightDetails> matchingFlights, List<FlightDetails> alternativeFlights) {
        LocalDate requestDate = DateUtils.parseDate(request.getDepartDate());
        
        for (FlightDetails flight : allFlights) {
            if (filterFlightsByRoute(flight, request)) {
                if (filterFlightsByDate(flight, requestDate)) {
                    matchingFlights.add(flight);
                } else {
                    alternativeFlights.add(flight);
                }
            }
        }
    }
    
    private boolean filterFlightsByRoute(FlightDetails flight, FlightSearchRequest request) {
        return flight.getOriginCity().equals(request.getOrigin()) && 
               flight.getDestinationCity().equals(request.getDestination());
    }
    
    private boolean filterFlightsByDate(FlightDetails flight, LocalDate requestDate) {
        return DateUtils.compareDates(flight.getDepartDate(), requestDate) == 0;
    }
    
    private List<FlightDetailsDTO> convertToDTO(List<FlightDetails> flights) {
        List<FlightDetailsDTO> dtoList = new ArrayList<>();
        for (FlightDetails flight : flights) {
            FlightDetailsDTO dto = new FlightDetailsDTO();
            dto.setFlightDetailsId(flight.getFlightDetailsId());
            dto.setOriginCity(flight.getOriginCity());
            dto.setDestinationCity(flight.getDestinationCity());
            dto.setDepartDate(flight.getDepartDate());
            dto.setDepartTime(flight.getDepartTime());
            dto.setArrivalTime(flight.getArrivalTime());
            dto.setEconomyFare(flight.getEconomyFare());
            dto.setBusinessFare(flight.getBusinessFare());
            dto.setFirstClassFare(flight.getFirstClassFare());
            dto.setCompany(flight.getCompany());
            dtoList.add(dto);
        }
        return dtoList;
    }
    
    private FlightDetailsDto convertToFlightDto(FlightDetails flightDetails) {
        FlightDetailsDto dto = new FlightDetailsDto();
        dto.setFlightDetailsId(flightDetails.getFlightDetailsId());
        dto.setOriginCity(flightDetails.getOriginCity());
        dto.setDestinationCity(flightDetails.getDestinationCity());
        dto.setOriginAirport(flightDetails.getOriginAirport());
        dto.setDestinationAirport(flightDetails.getDestinationAirport());
        dto.setDepartDate(flightDetails.getDepartDate());
        dto.setDepartTime(flightDetails.getDepartTime());
        dto.setArrivalDate(flightDetails.getArrivalDate());
        dto.setArrivalTime(flightDetails.getArrivalTime());
        dto.setCompany(flightDetails.getCompany());
        dto.setEconomyFare(flightDetails.getEconomyFare());
        dto.setBusinessFare(flightDetails.getBusinessFare());
        dto.setFirstClassFare(flightDetails.getFirstClassFare());
        return dto;
    }
}