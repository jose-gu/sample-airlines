package com.crossairlines.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

public class FlightDto {
    
    private int flightDetailsId;
    
    @NotNull(message = "From country is required")
    @Size(min = 1, message = "From country cannot be empty")
    private String fromCountry;
    
    @NotNull(message = "Destination country is required")
    @Size(min = 1, message = "Destination country cannot be empty")
    private String destCountry;
    
    @NotNull(message = "Origin city is required")
    @Size(min = 1, message = "Origin city cannot be empty")
    private String originCity;
    
    @NotNull(message = "Destination city is required")
    @Size(min = 1, message = "Destination city cannot be empty")
    private String destinationCity;
    
    @NotNull(message = "Origin airport is required")
    @Size(min = 1, message = "Origin airport cannot be empty")
    private String originAirport;
    
    @NotNull(message = "Destination airport is required")
    @Size(min = 1, message = "Destination airport cannot be empty")
    private String destinationAirport;
    
    private Date departDate;
    private String departDatet;
    
    @NotNull(message = "Departure time is required")
    private String departTime;
    
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
    @Size(min = 1, message = "Company cannot be empty")
    private String company;
    
    @NotNull(message = "Flight type is required")
    private String flightType;
    
    private double timeTaken;
    private int size;
    private int seatsAvailable;
    private int users;
    private Date bookingDate;
    private int userId;
    
    // Default constructor
    public FlightDto() {}
    
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
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    
    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
    
    public int getUsers() {
        return users;
    }
    
    public void setUsers(int users) {
        this.users = users;
    }
    
    public Date getBookingDate() {
        return bookingDate;
    }
    
    public void setBookingDate(String bookingDate) {
        try {
            this.bookingDate = new SimpleDateFormat("yyyy-MM-dd").parse(bookingDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    @Override
    public String toString() {
        return "FlightDto [flightDetailsId=" + flightDetailsId + ", fromCountry=" + fromCountry + ", destCountry="
                + destCountry + ", originCity=" + originCity + ", destinationCity=" + destinationCity
                + ", originAirport=" + originAirport + ", destinationAirport=" + destinationAirport + ", departDate="
                + departDate + ", departTime=" + departTime + ", arrivalDate=" + arrivalDate + ", arrivalTime="
                + arrivalTime + ", economyFare=" + economyFare + ", businessFare=" + businessFare + ", firstClassFare="
                + firstClassFare + ", company=" + company + ", flightType=" + flightType + ", timeTaken=" + timeTaken
                + ", size=" + size + ", seatsAvailable=" + seatsAvailable + ", users=" + users + ", bookingDate="
                + bookingDate + ", userId=" + userId + "]";
    }
}