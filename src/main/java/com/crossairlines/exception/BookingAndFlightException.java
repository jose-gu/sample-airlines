package com.crossairlines.exception;

public class BookingException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private String errorCode;
    
    public BookingException(String message) {
        super(message);
    }
    
    public BookingException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BookingException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public BookingException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}

class FlightNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public FlightNotFoundException(String message) {
        super(message);
    }

    public FlightNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

class AuthenticationRequiredException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public AuthenticationRequiredException(String message) {
        super(message);
    }

    public AuthenticationRequiredException(String message, Throwable cause) {
        super(message, cause);
    }
}