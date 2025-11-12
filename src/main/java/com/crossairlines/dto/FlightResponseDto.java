package com.crossairlines.dto;

import java.util.Date;

public class FlightResponseDto {
    
    private int flightDetailsId;
    private String fromCountry;
    private String destCountry;
    private String originCity;
    private String destinationCity;
    private String originAirport;
    private String destinationAirport;
    private Date departDate;
    private String departTime;
    private Date arrivalDate;
    private String arrivalTime;
    private double economyFare;
    private double businessFare;
    private double firstClassFare;
    private String company;
    private String flightType;
    private double timeTaken;
    private int seatsAvailabe;
    private String message;
    private String status;
    
    // Default constructor
    public FlightResponseDto() {}
    
    // Getters and Setters
    public int getFlightDetailsId() {
        return flightDetailsId;
    }
    
    public void setFlightDetailsId(int flightDetailsId) {
        this.flightDetailsId = flightDetailsId;
    }
    
    public String getFromCountry() {
        return fromCountry;
    }
    
    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }
    
    public String getDestCountry() {
        return destCountry;
    }
    
    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
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
    
    public String getOriginAirport() {
        return originAirport;
    }
    
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }
    
    public String getDestinationAirport() {
        return destinationAirport;
    }
    
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
    
    public Date getDepartDate() {
        return departDate;
    }
    
    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }
    
    public String getDepartTime() {
        return departTime;
    }
    
    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }
    
    public Date getArrivalDate() {
        return arrivalDate;
    }
    
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public String getArrivalTime() {
        return arrivalTime;
    }
    
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    public double getEconomyFare() {
        return economyFare;
    }
    
    public void setEconomyFare(double economyFare) {
        this.economyFare = economyFare;
    }
    
    public double getBusinessFare() {
        return businessFare;
    }
    
    public void setBusinessFare(double businessFare) {
        this.businessFare = businessFare;
    }
    
    public double getFirstClassFare() {
        return firstClassFare;
    }
    
    public void setFirstClassFare(double firstClassFare) {
        this.firstClassFare = firstClassFare;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getFlightType() {
        return flightType;
    }
    
    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
    
    public double getTimeTaken() {
        return timeTaken;
    }
    
    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }
    
    public int getSeatsAvailabe() {
        return seatsAvailabe;
    }
    
    public void setSeatsAvailabe(int seatsAvailabe) {
        this.seatsAvailabe = seatsAvailabe;
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
}