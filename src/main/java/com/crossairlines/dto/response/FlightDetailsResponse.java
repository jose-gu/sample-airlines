package com.crossairlines.dto.response;

public class FlightDetailsResponse {
    
    private Long flightId;
    private String company;
    private String originCity;
    private String destinationCity;
    private String departDate;
    private String arrivalDate;
    private String departTime;
    private String arrivalTime;
    
    public Long getFlightId() {
        return flightId;
    }
    
    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getOriginCity() {
        return originCity;
    }
    
    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }
    
    public String getDestinationCity() {
        return destinationCity;
    }
    
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
    
    public String getDepartDate() {
        return departDate;
    }
    
    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }
    
    public String getArrivalDate() {
        return arrivalDate;
    }
    
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public String getDepartTime() {
        return departTime;
    }
    
    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }
    
    public String getArrivalTime() {
        return arrivalTime;
    }
    
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}