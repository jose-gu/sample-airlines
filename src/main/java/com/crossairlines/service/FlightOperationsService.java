package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crossairlines.dto.FlightDto;
import com.crossairlines.dto.request.SearchFlightRequest;
import com.crossairlines.dto.response.FlightSearchResponse;
import com.crossairlines.mapper.FlightMapper;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.repository.FlightRepository;
import com.crossairlines.util.DateUtils;
import com.crossairlines.dto.BookTicketDto;
import com.crossairlines.dto.BookingResponse;
import com.crossairlines.dto.FlightDetailsDto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class FlightOperationsService {
    
    @Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private FlightMapper flightMapper;
    
    @Autowired
    private UserAuthenticationService authenticationService;
    
    public FlightSearchResponse searchFlights(SearchFlightRequest request) {
        System.out.println(request);
        
        List<FlightDetails> matchedFlights = new ArrayList<>();
        List<FlightDetails> alternativeFlights = new ArrayList<>();
        
        List<FlightDetails> allFlights = flightRepository.findByOriginCityAndDestinationCity(
            request.getOrigin(), request.getDestination());
        
        System.out.println(allFlights);
        
        Date searchDate = DateUtils.parseStringToLocalDate(request.getDepartDate());
        
        for (FlightDetails fd : allFlights) {
            if (fd.getOriginCity().equals(request.getOrigin()) && 
                request.getDestination().equals(fd.getDestinationCity())) {
                
                if (DateUtils.compareDates(searchDate, fd.getDepartDate()) == 0) {
                    matchedFlights.add(fd);
                } else {
                    alternativeFlights.add(fd);
                }
            }
        }
        
        List<FlightDto> matchedFlightDtos = matchedFlights.stream()
            .map(flightMapper::toDto)
            .collect(Collectors.toList());
            
        List<FlightDto> alternativeFlightDtos = alternativeFlights.stream()
            .map(flightMapper::toDto)
            .collect(Collectors.toList());
        
        return new FlightSearchResponse(matchedFlightDtos, alternativeFlightDtos);
    }
    
    private List<FlightDetails> filterFlightsByDate(List<FlightDetails> flights, String departDate) {
        Date searchDate = DateUtils.parseStringToLocalDate(departDate);
        return flights.stream()
            .filter(flight -> DateUtils.compareDates(searchDate, flight.getDepartDate()) == 0)
            .collect(Collectors.toList());
    }
    
    private List<FlightDto> convertToDto(List<FlightDetails> flights) {
        return flights.stream()
            .map(flightMapper::toDto)
            .collect(Collectors.toList());
    }
    
    public FlightDetails getFlightById(int id) {
        return flightRepository.findById(id).orElse(null);
    }

    public boolean validateBookingRequest(BookTicketDto bookTicketDto) {
        return bookTicketDto != null && bookTicketDto.getId() > 0;
    }

    public BookingResponse processBookingFlow(BookTicketDto bookTicketDto, HttpServletRequest request) {
        if (!validateBookingRequest(bookTicketDto)) {
            BookingResponse response = new BookingResponse();
            response.setRequiresLogin(true);
            response.setRedirectUrl("/login");
            return response;
        }
        
        FlightDetails flightDetails = getFlightById(bookTicketDto.getId());
        if (flightDetails == null) {
            BookingResponse response = new BookingResponse();
            response.setRequiresLogin(true);
            response.setRedirectUrl("/login");
            return response;
        }
        
        // Store flight details in session
        request.getSession().setAttribute("confirmFlight", flightDetails);
        
        // Check authentication
        if (!authenticationService.validateUserSession(request)) {
            BookingResponse response = new BookingResponse();
            response.setRequiresLogin(true);
            response.setRedirectUrl("/login");
            return response;
        }
        
        // Create successful response
        BookingResponse response = new BookingResponse();
        response.setRequiresLogin(false);
        response.setRedirectUrl("/bookMyTicket");
        
        FlightDetailsDto flightDto = new FlightDetailsDto();
        flightDto.setFlightId(flightDetails.getFlightDetailsId());
        flightDto.setOriginCity(flightDetails.getOriginCity());
        flightDto.setDestinationCity(flightDetails.getDestinationCity());
        flightDto.setDepartDate(flightDetails.getDepartDate());
        flightDto.setFare(flightDetails.getEconomyFare());
        
        response.setFlightDetails(flightDto);
        
        return response;
    }
}