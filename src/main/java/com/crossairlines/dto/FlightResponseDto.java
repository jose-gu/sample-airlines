package com.crossairlines.dto;

public class FlightResponseDto {
    
    private String message;
    private boolean success;
    private int flightId;
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public int getFlightId() {
        return flightId;
    }
    
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
    
    @Override
    public String toString() {
        return "FlightResponseDto [message=" + message + ", success=" + success + ", flightId=" + flightId + "]";
    }
}