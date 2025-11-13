package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.dto.FlightSearchRequest;
import com.crossairlines.dto.FlightSearchResponse;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.repository.FlightRepository;
import com.crossairlines.util.DateUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FlightManagementService {
    
    @Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private DateUtils dateUtils;
    
    public FlightSearchResponse searchFlights(FlightSearchRequest request) {
        List<FlightDetails> allFlights = flightRepository.findByOriginCityAndDestinationCity(
            request.getOrigin(), request.getDestination());
        
        List<FlightDto> matchedFlights = new ArrayList<>();
        List<FlightDto> alternativeFlights = new ArrayList<>();
        
        Date searchDate = dateUtils.parseDate(request.getDepartDate());
        
        for (FlightDetails fd : allFlights) {
            FlightDto flightDto = convertToDto(fd);
            
            if (dateUtils.compareDates(searchDate, fd.getDepartDate()) == 0) {
                matchedFlights.add(flightDto);
            } else {
                alternativeFlights.add(flightDto);
            }
        }
        
        FlightSearchResponse response = new FlightSearchResponse();
        response.setMatchedFlights(matchedFlights);
        response.setAlternativeFlights(alternativeFlights);
        response.setSearchCriteria(request);
        
        return response;
    }
    
    private FlightDto convertToDto(FlightDetails flightDetails) {
        FlightDto dto = new FlightDto();
        dto.setFlightDetailsId(flightDetails.getFlightDetailsId());
        dto.setCompany(flightDetails.getCompany());
        dto.setOriginCity(flightDetails.getOriginCity());
        dto.setDestinationCity(flightDetails.getDestinationCity());
        dto.setDepartDate(flightDetails.getDepartDate());
        dto.setDepartTime(flightDetails.getDepartTime());
        dto.setEconomyFare(flightDetails.getEconomyFare());
        dto.setBusinessFare(flightDetails.getBusinessFare());
        dto.setFirstClassFare(flightDetails.getFirstClassFare());
        return dto;
    }
    
    public FlightDetails getFlightDetail(int id) {
        return flightRepository.findById(id).orElse(null);
    }
    
    public void prepareBookingSession(FlightDetails flightDetails) {
        System.out.println("Preparing booking session for flight: " + flightDetails.getFlightDetailsId());
    }
    
    public void storeFlightInSession(HttpSession session, String attributeName, FlightDetails flightDetails) {
        session.setAttribute(attributeName, flightDetails);
    }
    
    public Object getSessionAttribute(HttpSession session, String attributeName) {
        return session.getAttribute(attributeName);
    }
}