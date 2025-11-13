package com.crossairlines.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

public class FlightRequestDto {
    
    @NotBlank(message = "From country is required")
    private String fromCountry;
    
    @NotBlank(message = "Destination country is required")
    private String destCountry;
    
    @NotBlank(message = "Origin city is required")
    private String originCity;
    
    @NotBlank(message = "Destination city is required")
    private String destinationCity;
    
    @NotBlank(message = "Origin airport is required")
    private String originAirport;
    
    @NotBlank(message = "Destination airport is required")
    private String destinationAirport;
    
    @NotNull(message = "Departure date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departDate;
    
    private String departDatet;
    
    @NotBlank(message = "Departure time is required")
    private String departTime;
    
    @NotNull(message = "Arrival date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;
    
    private String arrivalDatet;
    
    @NotBlank(message = "Arrival time is required")
    private String arrivalTime;
    
    @Positive(message = "Economy fare must be positive")
    private double economyFare;
    
    @Positive(message = "Business fare must be positive")
    private double businessFare;
    
    @Positive(message = "First class fare must be positive")
    private double firstClassFare;
    
    @NotBlank(message = "Company is required")
    private String company;
    
    @NotBlank(message = "Flight type is required")
    private String flightType;
    
    private double timeTaken;
    private int seatsAvailabe = 100;

    // Default constructor
    public FlightRequestDto() {}

    // Getters and setters
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

    public String getDepartDatet() {
        return departDatet;
    }

    public void setDepartDatet(String departDatet) {
        try {
            this.departDate = new SimpleDateFormat("yyyy-MM-dd").parse(departDatet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.departDatet = departDatet;
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

    public String getArrivalDatet() {
        return arrivalDatet;
    }

    public void setArrivalDatet(String arrivalDatet) {
        try {
            this.arrivalDate = new SimpleDateFormat("yyyy-MM-dd").parse(arrivalDatet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.arrivalDatet = arrivalDatet;
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

    @Override
    public String toString() {
        return "FlightRequestDto [fromCountry=" + fromCountry + ", destCountry=" + destCountry + ", originCity="
                + originCity + ", destinationCity=" + destinationCity + ", originAirport=" + originAirport
                + ", destinationAirport=" + destinationAirport + ", departDate=" + departDate + ", departTime="
                + departTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", economyFare="
                + economyFare + ", businessFare=" + businessFare + ", firstClassFare=" + firstClassFare + ", company="
                + company + ", flightType=" + flightType + ", timeTaken=" + timeTaken + ", seatsAvailabe="
                + seatsAvailabe + "]";
    }
}