package com.crossairlines.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlightSearchRequest {
    
    private String flightType;
    
    @NotBlank(message = "Origin is required")
    private String origin;
    
    @NotBlank(message = "Destination is required")
    private String destination;
    
    @NotBlank(message = "Depart date is required")
    private String departDate;
    
    private String returnDate;
    
    private String multicity;
    
    public String getFlightType() {
        return flightType;
    }
    
    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getDepartDate() {
        return departDate;
    }
    
    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }
    
    public String getReturnDate() {
        return returnDate;
    }
    
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    
    public String getMulticity() {
        return multicity;
    }
    
    public void setMulticity(String multicity) {
        this.multicity = multicity;
    }
    
    @Override
    public String toString() {
        return "FlightSearchRequest [flightType=" + flightType + ", origin=" + origin + ", destination=" + destination
                + ", departDate=" + departDate + ", returnDate=" + returnDate + ", multicity=" + multicity + "]";
    }
}