package com.crossairlines.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "flight_details")
public class FlightEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_details_id")
    private Long flightDetailsId;
    
    @Column(name = "from_country")
    private String fromCountry;
    
    @Column(name = "dest_country")
    private String destCountry;
    
    @Column(name = "origin_city")
    private String originCity;
    
    @Column(name = "destination_city")
    private String destinationCity;
    
    @Column(name = "origin_airport")
    private String originAirport;
    
    @Column(name = "destination_airport")
    private String destinationAirport;
    
    @Column(name = "depart_date")
    private Date departDate;
    
    @Column(name = "depart_time")
    private Time departTime;
    
    @Column(name = "arrival_date")
    private Date arrivalDate;
    
    @Column(name = "arrival_time")
    private Time arrivalTime;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "economy_fare")
    private double economyFare;
    
    @Column(name = "business_fare")
    private double businessFare;
    
    @Column(name = "first_class_fare")
    private double firstClassFare;
    
    @Column(name = "flight_type")
    private String flightType;
    
    @Column(name = "time_taken")
    private double timeTaken;
    
    @Column(name = "seats_available")
    private int seatsAvailable = 100;
    
    public Long getFlightDetailsId() {
        return flightDetailsId;
    }
    
    public void setFlightDetailsId(Long flightDetailsId) {
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
    
    public Time getDepartTime() {
        return departTime;
    }
    
    public void setDepartTime(Time departTime) {
        this.departTime = departTime;
    }
    
    public Date getArrivalDate() {
        return arrivalDate;
    }
    
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    
    public Time getArrivalTime() {
        return arrivalTime;
    }
    
    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
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
    
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    
    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}