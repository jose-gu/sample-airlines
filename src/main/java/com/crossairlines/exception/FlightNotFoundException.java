package com.crossairlines.exception;

public class FlightNotFoundException extends RuntimeException {
    
    public FlightNotFoundException(String message) {
        super(message);
    }
    
    public FlightNotFoundException(Integer flightId) {
        super("Flight not found with ID: " + flightId);
    }
}