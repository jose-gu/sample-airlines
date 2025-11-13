package com.crossairlines.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

public class FlightRequestDto {
    
    private int flightDetailsId;
    
    @NotNull(message = "From country is required")
    @Size(min = 2, max = 100, message = "From country must be between 2 and 100 characters")
    private String fromCountry;
    
    @NotNull(message = "Destination country is required")
    @Size(min = 2, max = 100, message = "Destination country must be between 2 and 100 characters")
    private String destCountry;
    
    @NotNull(message = "Origin city is required")
    @Size(min = 2, max = 100, message = "Origin city must be between 2 and 100 characters")
    private String originCity;
    
    @NotNull(message = "Destination city is required")
    @Size(min = 2, max = 100, message = "Destination city must be between 2 and 100 characters")
    private String destinationCity;
    
    @NotNull(message = "Origin airport is required")
    @Size(min = 2, max = 100, message = "Origin airport must be between 2 and 100 characters")
    private String originAirport;
    
    @NotNull(message = "Destination airport is required")
    @Size(min = 2, max = 100, message = "Destination airport must be between 2 and 100 characters")
    private String destinationAirport;
    
    @NotNull(message = "Departure date is required")
    private Date departDate;
    
    private String departDatet;
    
    @NotNull(message = "Departure time is required")
    private String departTime;
    
    @NotNull(message = "Arrival date is required")
    private Date arrivalDate;
    
    private String arrivalDatet;
    
    @NotNull(message = "Arrival time is required")
    private String arrivalTime;
    
    @Min(value = 0, message = "Economy fare must be positive")
    private double economyFare;
    
    @Min(value = 0, message = "Business fare must be positive")
    private double businessFare;
    
    @Min(value = 0, message = "First class fare must be positive")
    private double firstClassFare;
    
    @NotNull(message = "Company is required")
    @Size(min = 2, max = 100, message = "Company must be between 2 and 100 characters")
    private String company;
    
    @NotNull(message = "Flight type is required")
    private String flightType;
    
    @Min(value = 0, message = "Time taken must be positive")
    private double timeTaken;
    
    @Min(value = 1, message = "Seats available must be at least 1")
    private int seatsAvailabe = 100;
    
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
        return "FlightRequestDto [flightDetailsId=" + flightDetailsId + ", fromCountry=" + fromCountry + ", destCountry="
                + destCountry + ", originCity=" + originCity + ", destinationCity=" + destinationCity
                + ", originAirport=" + originAirport + ", destinationAirport=" + destinationAirport + ", departDate="
                + departDate + ", departTime=" + departTime + ", arrivalDate=" + arrivalDate + ", arrivalTime="
                + arrivalTime + ", economyFare=" + economyFare + ", businessFare=" + businessFare + ", firstClassFare="
                + firstClassFare + ", company=" + company + ", flightType=" + flightType + ", timeTaken=" + timeTaken
                + ", seatsAvailabe=" + seatsAvailabe + "]";
    }
}