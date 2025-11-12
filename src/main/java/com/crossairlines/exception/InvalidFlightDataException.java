package com.crossairlines.exception;

public class InvalidFlightDataException extends RuntimeException {
    
    public InvalidFlightDataException(String message) {
        super(message);
    }
    
    public InvalidFlightDataException(String field, String value) {
        super("Invalid flight data - " + field + ": " + value);
    }
}