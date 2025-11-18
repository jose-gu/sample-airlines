package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.crossairlines.dto.request.BookTicketRequest;
import com.crossairlines.dto.request.BookingCheckoutRequest;
import com.crossairlines.dto.request.CheckoutRequest;
import com.crossairlines.dto.response.BookTicketResponse;
import com.crossairlines.dto.response.BookingCheckoutResponse;
import com.crossairlines.dto.response.CheckoutResponse;
import com.crossairlines.dto.FlightDetailsDto;
import com.crossairlines.service.BookingService;
import com.crossairlines.service.SessionService;
import com.crossairlines.service.FlightService;
import com.crossairlines.service.AuthenticationService;
import com.crossairlines.service.SessionManager;
import com.crossairlines.service.BookTicketService;
import com.crossairlines.exception.AuthenticationRequiredException;
import com.crossairlines.exception.FlightNotFoundException;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private SessionService sessionService;
    
    @Autowired
    private FlightService flightService;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private SessionManager sessionManager;
    
    @Autowired
    private BookTicketService bookTicketService;

    @PostMapping("/book-ticket")
    public ResponseEntity<BookTicketResponse> bookTicket(
            @Valid @RequestBody BookTicketRequest request,
            HttpServletRequest httpRequest) {
        
        System.out.println("Book Ticket : " + request);
        
        try {
            // Validate the booking request
            flightService.validateBookingRequest(request);
            
            // Get flight details
            FlightDetailsDto flightDetails = flightService.getFlightDetails(request.getId());
            
            // Set flight details in session
            HttpSession session = httpRequest.getSession();
            sessionManager.setConfirmFlightSession(session, flightDetails);
            
            // Check user authentication
            boolean isAuthenticated = authenticationService.validateUserCookie(httpRequest);
            
            BookTicketResponse response = new BookTicketResponse();
            response.setFlightDetails(flightDetails);
            response.setUserAuthenticated(isAuthenticated);
            
            if (isAuthenticated) {
                response.setBookingStatus("AUTHENTICATED");
                response.setRedirectUrl("/pages/bookTicket.jsp");
            } else {
                response.setBookingStatus("AUTHENTICATION_REQUIRED");
                response.setRedirectUrl("/login.do");
            }
            
            return ResponseEntity.ok(response);
            
        } catch (FlightNotFoundException e) {
            BookTicketResponse response = new BookTicketResponse();
            response.setBookingStatus("FAILED");
            response.setMessage("Flight not found");
            return ResponseEntity.badRequest().body(response);
        } catch (AuthenticationRequiredException e) {
            BookTicketResponse response = new BookTicketResponse();
            response.setBookingStatus("AUTHENTICATION_REQUIRED");
            response.setRedirectUrl("/login");
            response.setMessage("Please login to continue booking");
            return ResponseEntity.status(401).body(response);
        } catch (Exception e) {
            BookTicketResponse response = bookTicketService.processBookingRequest(request, httpRequest);
            return ResponseEntity.ok(response);
        }
    }
    
    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(
            @Valid @RequestBody Object request,
            HttpServletRequest httpRequest) {
        
        System.out.println("Book Ticket : " + request);
        
        if (request instanceof BookingCheckoutRequest) {
            BookingCheckoutRequest checkoutRequest = (BookingCheckoutRequest) request;
            
            // Store booking data in session
            sessionService.storeBookingData(httpRequest.getSession(), "bookingTicket", checkoutRequest);
            
            // Process checkout
            BookingCheckoutResponse response = bookingService.processCheckout(checkoutRequest);
            
            return ResponseEntity.ok(response);
        } else if (request instanceof CheckoutRequest) {
            CheckoutRequest checkoutRequest = (CheckoutRequest) request;
            CheckoutResponse response = bookingService.processCheckout(checkoutRequest, httpRequest);
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.badRequest().body("Invalid request format");
    }
}