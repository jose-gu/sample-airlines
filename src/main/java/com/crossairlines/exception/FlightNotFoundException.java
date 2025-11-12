package com.crossairlines.exception;

public class FlightNotFoundException extends RuntimeException {
    
    public FlightNotFoundException(String message) {
        super(message);
    }
    
    public FlightNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public FlightNotFoundException(Long flightId) {
        super("Flight not found with ID: " + flightId);
    }
}