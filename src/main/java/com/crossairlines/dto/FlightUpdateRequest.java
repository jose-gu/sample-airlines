package com.crossairlines.dto;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Optional;

public class FlightUpdateRequest {
    @NotNull(message = "Flight ID is required")
    private Integer flightDetailsId;
    
    @Size(min = 2, max = 50, message = "From country must be between 2 and 50 characters")
    private String fromCountry;
    
    @Size(min = 2, max = 50, message = "Destination country must be between 2 and 50 characters")
    private String destCountry;
    
    @Size(min = 2, max = 50, message = "Origin city must be between 2 and 50 characters")
    private String originCity;
    
    @Size(min = 2, max = 50, message = "Destination city must be between 2 and 50 characters")
    private String destinationCity;
    
    @Size(min = 3, max = 100, message = "Origin airport must be between 3 and 100 characters")
    private String originAirport;
    
    @Size(min = 3, max = 100, message = "Destination airport must be between 3 and 100 characters")
    private String destinationAirport;
    
    @Future(message = "Departure date must be in the future")
    private Date departDate;
    
    @Future(message = "Arrival date must be in the future")
    private Date arrivalDate;
    
    private String departTime;
    
    private String arrivalTime;
    
    @Positive(message = "Economy fare must be positive")
    private Double economyFare;
    
    @Positive(message = "Business fare must be positive")
    private Double businessFare;
    
    @Positive(message = "First class fare must be positive")
    private Double firstClassFare;
    
    @Size(min = 2, max = 50, message = "Company must be between 2 and 50 characters")
    private String company;
    
    private String flightType;
    
    @PositiveOrZero(message = "Time taken must be positive or zero")
    private Double timeTaken;
    
    @Positive(message = "Seats available must be positive")
    private Integer seatsAvailable;
    
    public FlightUpdateRequest() {}
    
    public Integer getFlightDetailsId() {
        return flightDetailsId;
    }
    
    public void setFlightDetailsId(Integer flightDetailsId) {
        this.flightDetailsId = flightDetailsId;
    }
    
    public Optional<String> getFromCountry() {
        return Optional.ofNullable(fromCountry);
    }
    
    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }
    
    public Optional<String> getDestCountry() {
        return Optional.ofNullable(destCountry);
    }
    
    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
    }
    
    public Optional<String> getOriginCity() {
        return Optional.ofNullable(originCity);
    }
    
    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }
    
    public Optional<String> getDestinationCity() {
        return Optional.ofNullable(destinationCity);
    }
    
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
    
    public Optional<String> getOriginAirport() {
        return Optional.ofNullable(originAirport);
    }
    
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }
    
    public Optional<String> getDestinationAirport() {
        return Optional.ofNullable(destinationAirport);
    }
    
    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }
    
    public Optional<Date> getDepartDate() {
        return Optional.ofNullable(departDate);
    }
    
    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }
    
    public Optional<Date> getArrivalDate() {
        return Optional.ofNullable(arrivalDate);
    }
    
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public Optional<String> getDepartTime() {
        return Optional.ofNullable(departTime);
    }
    
    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }
    
    public Optional<String> getArrivalTime() {
        return Optional.ofNullable(arrivalTime);
    }
    
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    public Optional<Double> getEconomyFare() {
        return Optional.ofNullable(economyFare);
    }
    
    public void setEconomyFare(Double economyFare) {
        this.economyFare = economyFare;
    }
    
    public Optional<Double> getBusinessFare() {
        return Optional.ofNullable(businessFare);
    }
    
    public void setBusinessFare(Double businessFare) {
        this.businessFare = businessFare;
    }
    
    public Optional<Double> getFirstClassFare() {
        return Optional.ofNullable(firstClassFare);
    }
    
    public void setFirstClassFare(Double firstClassFare) {
        this.firstClassFare = firstClassFare;
    }
    
    public Optional<String> getCompany() {
        return Optional.ofNullable(company);
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public Optional<String> getFlightType() {
        return Optional.ofNullable(flightType);
    }
    
    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
    
    public Optional<Double> getTimeTaken() {
        return Optional.ofNullable(timeTaken);
    }
    
    public void setTimeTaken(Double timeTaken) {
        this.timeTaken = timeTaken;
    }
    
    public Optional<Integer> getSeatsAvailable() {
        return Optional.ofNullable(seatsAvailable);
    }
    
    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}