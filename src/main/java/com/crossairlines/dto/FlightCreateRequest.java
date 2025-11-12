package com.crossairlines.dto;

import javax.validation.constraints.*;
import java.util.Date;

public class FlightCreateRequest {
    @NotBlank(message = "From country is required")
    @Size(min = 2, max = 50, message = "From country must be between 2 and 50 characters")
    private String fromCountry;
    
    @NotBlank(message = "Destination country is required")
    @Size(min = 2, max = 50, message = "Destination country must be between 2 and 50 characters")
    private String destCountry;
    
    @NotBlank(message = "Origin city is required")
    @Size(min = 2, max = 50, message = "Origin city must be between 2 and 50 characters")
    private String originCity;
    
    @NotBlank(message = "Destination city is required")
    @Size(min = 2, max = 50, message = "Destination city must be between 2 and 50 characters")
    private String destinationCity;
    
    @NotBlank(message = "Origin airport is required")
    @Size(min = 3, max = 100, message = "Origin airport must be between 3 and 100 characters")
    private String originAirport;
    
    @NotBlank(message = "Destination airport is required")
    @Size(min = 3, max = 100, message = "Destination airport must be between 3 and 100 characters")
    private String destinationAirport;
    
    @NotNull(message = "Departure date is required")
    @Future(message = "Departure date must be in the future")
    private Date departDate;
    
    @NotNull(message = "Arrival date is required")
    @Future(message = "Arrival date must be in the future")
    private Date arrivalDate;
    
    @NotBlank(message = "Departure time is required")
    private String departTime;
    
    @NotBlank(message = "Arrival time is required")
    private String arrivalTime;
    
    @NotNull(message = "Economy fare is required")
    @Positive(message = "Economy fare must be positive")
    private Double economyFare;
    
    @NotNull(message = "Business fare is required")
    @Positive(message = "Business fare must be positive")
    private Double businessFare;
    
    @NotNull(message = "First class fare is required")
    @Positive(message = "First class fare must be positive")
    private Double firstClassFare;
    
    @NotBlank(message = "Company is required")
    @Size(min = 2, max = 50, message = "Company must be between 2 and 50 characters")
    private String company;
    
    @NotBlank(message = "Flight type is required")
    private String flightType;
    
    @PositiveOrZero(message = "Time taken must be positive or zero")
    private Double timeTaken;
    
    @NotNull(message = "Seats available is required")
    @Positive(message = "Seats available must be positive")
    private Integer seatsAvailable = 100;
    
    public FlightCreateRequest() {}
    
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
    
    public Date getArrivalDate() {
        return arrivalDate;
    }
    
    public void setArrivalDate(Date arrivalDate) {
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
    
    public Double getEconomyFare() {
        return economyFare;
    }
    
    public void setEconomyFare(Double economyFare) {
        this.economyFare = economyFare;
    }
    
    public Double getBusinessFare() {
        return businessFare;
    }
    
    public void setBusinessFare(Double businessFare) {
        this.businessFare = businessFare;
    }
    
    public Double getFirstClassFare() {
        return firstClassFare;
    }
    
    public void setFirstClassFare(Double firstClassFare) {
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
    
    public Double getTimeTaken() {
        return timeTaken;
    }
    
    public void setTimeTaken(Double timeTaken) {
        this.timeTaken = timeTaken;
    }
    
    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }
    
    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}