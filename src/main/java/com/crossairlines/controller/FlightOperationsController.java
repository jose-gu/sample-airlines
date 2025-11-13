package com.crossairlines.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossairlines.dto.FlightSearchRequest;
import com.crossairlines.dto.FlightSearchResponse;
import com.crossairlines.dto.request.BookTicketRequest;
import com.crossairlines.dto.response.BookTicketResponse;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.service.CookieAuthenticationService;
import com.crossairlines.service.FlightSearchService;
import com.crossairlines.service.FlightService;
import com.crossairlines.service.SessionService;

@RestController
@RequestMapping("/api/flights")
public class FlightOperationsController {
    
    @Autowired
    private FlightSearchService flightSearchService;
    
    @Autowired
    private FlightService flightService;
    
    @Autowired
    private CookieAuthenticationService cookieAuthenticationService;
    
    @Autowired
    private SessionService sessionService;
    
    @PostMapping("/search")
    public ResponseEntity<FlightSearchResponse> searchFlights(@RequestBody FlightSearchRequest request) {
        FlightSearchResponse response = flightSearchService.searchFlights(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/book-ticket")
    public ResponseEntity<BookTicketResponse> bookTicket(@Valid @RequestBody BookTicketRequest request, 
                                                        HttpServletRequest httpRequest) {
        System.out.println("Book Ticket : " + request);
        
        FlightDetails flightDetails = flightService.getFlightDetail(request.getId());
        sessionService.storeFlightInSession(httpRequest.getSession(), "confirmFlight", flightDetails);
        
        boolean isAuthenticated = cookieAuthenticationService.validateLoginCookie(httpRequest);
        
        BookTicketResponse response = new BookTicketResponse();
        response.setFlightDetails(flightDetails);
        
        if (isAuthenticated) {
            response.setRedirectUrl("/book-my-ticket");
            response.setStatus("authenticated");
        } else {
            response.setRedirectUrl("/login");
            response.setStatus("redirect_to_login");
        }
        
        return ResponseEntity.ok(response);
    }
}