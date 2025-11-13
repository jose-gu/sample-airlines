package com.crossairlines.dto;

public class FlightResponseDto {
    
    private int flightDetailsId;
    private String message;
    private String status;

    // Default constructor
    public FlightResponseDto() {}

    // Constructor with parameters
    public FlightResponseDto(int flightDetailsId, String message, String status) {
        this.flightDetailsId = flightDetailsId;
        this.message = message;
        this.status = status;
    }

    // Getters and setters
    public int getFlightDetailsId() {
        return flightDetailsId;
    }

    public void setFlightDetailsId(int flightDetailsId) {
        this.flightDetailsId = flightDetailsId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FlightResponseDto [flightDetailsId=" + flightDetailsId + ", message=" + message + ", status=" + status + "]";
    }
}