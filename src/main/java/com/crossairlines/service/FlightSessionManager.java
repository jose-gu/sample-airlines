package com.crossairlines.service;

import org.springframework.stereotype.Service;
import com.crossairlines.model.Flight;
import com.crossairlines.dto.FlightDetailsDto;
import com.crossairlines.dto.request.CheckoutRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class FlightSessionManager {

    public void storeFlightInSession(HttpServletRequest request, Flight flight) {
        HttpSession session = request.getSession();
        session.setAttribute("confirmFlight", flight);
    }
    
    public Flight retrieveSessionData(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (Flight) session.getAttribute(key);
        }
        return null;
    }
    
    public void clearSessionData(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(key);
        }
    }
    
    public void setConfirmFlightSession(HttpSession session, FlightDetailsDto flightDetails) {
        session.setAttribute("confirmFlight", flightDetails);
    }
    
    public Object getSessionAttribute(HttpSession session, String attributeName) {
        return session.getAttribute(attributeName);
    }
    
    public void setSessionAttribute(HttpSession session, String attributeName, Object value) {
        session.setAttribute(attributeName, value);
    }
    
    public FlightDetailsDto getConfirmFlightFromSession(HttpSession session) {
        return (FlightDetailsDto) session.getAttribute("confirmFlight");
    }
    
    public void storeBookingData(HttpSession session, String key, Object data) {
        session.setAttribute(key, data);
    }
    
    public void storeBookingData(HttpServletRequest request, CheckoutRequest checkoutRequest) {
        request.getSession().setAttribute("bookingTicket", checkoutRequest);
    }
    
    public CheckoutRequest retrieveBookingData(HttpServletRequest request) {
        return (CheckoutRequest) request.getSession().getAttribute("bookingTicket");
    }
}