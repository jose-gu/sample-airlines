package com.crossairlines.dto;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class FlightCreateDTO {
    
    @NotBlank(message = "From country is required")
    private String fromCountry;
    
    @NotBlank(message = "Destination country is required")
    private String destinationCountry;
    
    @NotBlank(message = "Origin city is required")
    private String originCity;
    
    @NotBlank(message = "Destination city is required")
    private String destinationCity;
    
    @NotBlank(message = "Origin airport is required")
    private String originAirport;
    
    @NotBlank(message = "Destination airport is required")
    private String destinationAirport;
    
    @NotNull(message = "Departure date is required")
    @Future(message = "Departure date must be in the future")
    private LocalDateTime departDate;
    
    @NotNull(message = "Arrival date is required")
    @Future(message = "Arrival date must be in the future")
    private LocalDateTime arrivalDate;
    
    @NotNull(message = "Economy fare is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Economy fare must be greater than 0")
    private Double economyFare;
    
    @NotNull(message = "Business fare is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Business fare must be greater than 0")
    private Double businessFare;
    
    @NotNull(message = "First class fare is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "First class fare must be greater than 0")
    private Double firstClassFare;
    
    @NotBlank(message = "Company is required")
    private String company;
    
    @NotBlank(message = "Flight type is required")
    @Pattern(regexp = "Non Stop|One Stop|Multi Stop", message = "Flight type must be Non Stop, One Stop, or Multi Stop")
    private String flightType;
    
    private Double timeTaken;
    
    @Min(value = 1, message = "Seats available must be at least 1")
    private Integer seatsAvailable = 100;

    public FlightCreateDTO() {}

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
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

    public LocalDateTime getDepartDate() {
        return departDate;
    }

    public void setDepartDate(LocalDateTime departDate) {
        this.departDate = departDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
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