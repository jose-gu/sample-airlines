package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.crossairlines.dto.request.BookTicketRequest;
import com.crossairlines.dto.response.BookTicketResponse;
import com.crossairlines.dto.request.PaymentRequest;
import com.crossairlines.dto.response.PaymentResponse;
import com.crossairlines.dto.FlightDetailsDto;
import com.crossairlines.exception.BookingException;
import com.crossairlines.model.*;
import com.crossairlines.repository.*;

@Service
public class BookingAndPaymentService {

    @Autowired
    private FlightManagementService flightManagementService;
    
    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private SessionService sessionService;
    
    @Autowired
    private UserManagementService userManagementService;
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private BookTicketRepository bookTicketRepository;

    public BookTicketResponse initiateBooking(BookTicketRequest request, HttpServletRequest httpRequest) {
        System.out.println("Book Ticket : " + request);
        
        // Get flight details
        Flight flight = flightManagementService.getFlightById(request.getFlightId());
        if (flight == null) {
            throw new BookingException("Flight not found with id: " + request.getFlightId());
        }
        
        // Store flight in session
        sessionService.storeFlightInSession(httpRequest, flight);
        
        // Validate user authentication
        boolean isAuthenticated = validateUserAuthentication(httpRequest);
        
        BookTicketResponse response = new BookTicketResponse();
        
        if (isAuthenticated) {
            response.setSuccess(true);
            response.setRedirectUrl("/pages/bookTicket.jsp");
            response.setMessage("User authenticated successfully");
        } else {
            response.setSuccess(false);
            response.setRedirectUrl("/login.do");
            response.setMessage("User authentication required");
        }
        
        // Set flight details in response
        FlightDetailsDto flightDetailsDto = mapToFlightDetailsDto(flight);
        response.setFlightDetails(flightDetailsDto);
        
        return response;
    }
    
    @Transactional
    public PaymentResponse processPayment(PaymentRequest paymentRequest, HttpServletRequest request) {
        // Get user from cookie
        User user = getCurrentUserFromRequest(request);
        
        // Create payment entity
        Payment payment = createPaymentEntity(paymentRequest, user);
        
        // Create booking ticket entity
        BookTicket bookTicket = createBookTicketEntity(paymentRequest, user);
        
        // Set relationships
        payment.setBookTicket(bookTicket);
        bookTicket.setPayment(payment);
        
        // Save entities
        confirmBooking(bookTicket, payment);
        
        // Create response
        return createPaymentResponse(bookTicket, payment);
    }
    
    public boolean validateUserAuthentication(HttpServletRequest request) {
        return authenticationService.isUserAuthenticated(request);
    }
    
    public User getCurrentUserFromRequest(HttpServletRequest request) {
        int userId = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginidCookie".equals(cookie.getName())) {
                    userId = Integer.parseInt(cookie.getValue());
                    System.out.println(userId);
                    break;
                }
            }
        }
        System.out.println(userId);
        return userManagementService.getUserById((long) userId);
    }
    
    private FlightDetailsDto mapToFlightDetailsDto(Flight flight) {
        FlightDetailsDto dto = new FlightDetailsDto();
        dto.setFlightId(flight.getFlightId());
        dto.setOriginCity(flight.getOriginCity());
        dto.setDestinationCity(flight.getDestinationCity());
        dto.setDepartDate(flight.getDepartDate());
        dto.setEconomyFare(flight.getEconomyFare());
        dto.setBusinessFare(flight.getBusinessFare());
        dto.setFirstClassFare(flight.getFirstClassFare());
        return dto;
    }
    
    private Payment createPaymentEntity(PaymentRequest paymentRequest, User user) {
        Payment payment = new Payment();
        payment.setCardNumber(paymentRequest.getCardNumber());
        payment.setCardHolderName(paymentRequest.getCardHolderName());
        payment.setExpiryDate(paymentRequest.getExpiryDate());
        payment.setCvvNo(paymentRequest.getCvvNo());
        payment.setAmount(paymentRequest.getAmount());
        payment.setUser(user);
        return payment;
    }
    
    private BookTicket createBookTicketEntity(PaymentRequest paymentRequest, User user) {
        BookTicket bookTicket = new BookTicket();
        bookTicket.setUser(user);
        return bookTicket;
    }
    
    @Transactional
    public void confirmBooking(BookTicket bookTicket, Payment payment) {
        bookTicketRepository.save(bookTicket);
        paymentRepository.save(payment);
    }
    
    private PaymentResponse createPaymentResponse(BookTicket bookTicket, Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setBookingId(bookTicket.getId());
        response.setPaymentStatus("SUCCESS");
        response.setConfirmationNumber("CONF" + bookTicket.getId());
        
        PaymentResponse.TicketDetails ticketDetails = new PaymentResponse.TicketDetails();
        ticketDetails.setAdultCount(bookTicket.getAdultCount());
        ticketDetails.setChildCount(bookTicket.getChildCount());
        ticketDetails.setFinalFare(bookTicket.getFinalFare());
        ticketDetails.setClassType(bookTicket.getClassType());
        
        if (bookTicket.getFlightDetails() != null) {
            ticketDetails.setFlightCompany(bookTicket.getFlightDetails().getCompany());
            ticketDetails.setOriginCity(bookTicket.getFlightDetails().getOriginCity());
            ticketDetails.setDestinationCity(bookTicket.getFlightDetails().getDestinationCity());
        }
        
        response.setTicketDetails(ticketDetails);
        return response;
    }
}