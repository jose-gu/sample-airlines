package com.crossairlines.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.validation.constraints.NotNull;

public class FlightDetailsDto {
    
    @NotNull(message = "Flight ID is required")
    private int flightDetailsId;
    
    private String originCity;
    private String destinationCity;
    private String originAirport;
    private String destinationAirport;
    private Date departDate;
    private String departTime;
    private String arrivalTime;
    private double economyFare;
    private double businessFare;
    private double firstClassFare;
    private String company;
    private int seatsAvailable;
    private double fare;
    
    public int getFlightDetailsId() {
        return flightDetailsId;
    }
    
    public void setFlightDetailsId(int flightDetailsId) {
        this.flightDetailsId = flightDetailsId;
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
    
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    
    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
    
    public double getFare() {
        return fare;
    }
    
    public void setFare(double fare) {
        this.fare = fare;
    }
    
    @Override
    public String toString() {
        return "FlightDetailsDto [flightDetailsId=" + flightDetailsId + ", originCity=" + originCity + ", destinationCity="
                + destinationCity + ", departDate=" + departDate + ", fare=" + fare + ", company=" + company
                + ", originAirport=" + originAirport + ", destinationAirport=" + destinationAirport + ", departTime="
                + departTime + ", arrivalTime=" + arrivalTime + ", economyFare=" + economyFare + ", businessFare=" + businessFare
                + ", firstClassFare=" + firstClassFare + ", seatsAvailable=" + seatsAvailable + "]";
    }
}