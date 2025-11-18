package com.crossairlines.mapper;

import org.springframework.stereotype.Component;

import com.crossairlines.dto.request.CheckoutRequest;
import com.crossairlines.dto.response.CheckoutResponse;
import com.crossairlines.dto.response.FlightDetailsResponse;
import com.crossairlines.model.Flight;

@Component
public class BookingMapper {
    
    public CheckoutResponse toCheckoutResponse(Flight flight, CheckoutRequest request, Integer totalPassengers) {
        CheckoutResponse response = new CheckoutResponse();
        response.setFlightDetails(toFlightDetailsResponse(flight));
        response.setPassengerCount(totalPassengers);
        response.setTotalFare(request.getFinalFare());
        response.setClassType(request.getClassType());
        return response;
    }
    
    public FlightDetailsResponse toFlightDetailsResponse(Flight flight) {
        FlightDetailsResponse response = new FlightDetailsResponse();
        response.setFlightId(flight.getFlightId());
        response.setCompany(flight.getCompany());
        response.setOriginCity(flight.getOriginCity());
        response.setDestinationCity(flight.getDestinationCity());
        response.setDepartDate(flight.getDepartDate());
        response.setArrivalDate(flight.getArrivalDate());
        response.setDepartTime(flight.getDepartTime());
        response.setArrivalTime(flight.getArrivalTime());
        return response;
    }
}