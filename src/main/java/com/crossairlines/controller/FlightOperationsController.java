package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import com.crossairlines.dto.request.SearchFlightRequest;
import com.crossairlines.dto.response.FlightSearchResponse;
import com.crossairlines.dto.BookTicketDto;
import com.crossairlines.dto.BookingResponse;
import com.crossairlines.service.FlightSearchService;
import com.crossairlines.service.AuthenticationService;
import com.crossairlines.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightOperationsController {
    
    @Autowired
    private FlightSearchService flightSearchService;
    
    @Autowired
    private FlightService flightService;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @PostMapping("/search")
    public ResponseEntity<FlightSearchResponse> searchFlights(
            @Valid @RequestBody SearchFlightRequest request) {
        
        FlightSearchResponse response = flightSearchService.searchFlights(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/bookTicket")
    public ResponseEntity<BookingResponse> bookTicket(@Valid @RequestBody BookTicketDto bookTicketDto, 
                                                     HttpServletRequest request) throws Exception {
        System.out.println("Book Ticket : " + bookTicketDto);
        
        BookingResponse response = flightService.processBookingFlow(bookTicketDto, request);
        
        if (response.isRequiresLogin()) {
            return ResponseEntity.status(401).body(response);
        }
        
        return ResponseEntity.ok(response);
    }
}