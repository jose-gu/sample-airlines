package com.crossairlines.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight_details")
public class FlightDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_details_id")
    private int flightDetailsId;
    
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
    @Temporal(TemporalType.DATE)
    private Date departDate;
    
    @Column(name = "depart_time")
    private String departTime;
    
    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    
    @Column(name = "arrival_time")
    private String arrivalTime;
    
    @Column(name = "economy_fare")
    private double economyFare;
    
    @Column(name = "business_fare")
    private double businessFare;
    
    @Column(name = "first_class_fare")
    private double firstClassFare;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "flight_type")
    private String flightType;
    
    @Column(name = "time_taken")
    private double timeTaken;
    
    @Column(name = "seats_available")
    private int seatsAvailable = 100;
    
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
    
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    
    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
    
    @Override
    public String toString() {
        return "FlightDetails [flightDetailsId=" + flightDetailsId + ", fromCountry=" + fromCountry + ", destCountry="
                + destCountry + ", originCity=" + originCity + ", destinationCity=" + destinationCity
                + ", originAirport=" + originAirport + ", destinationAirport=" + destinationAirport + ", departDate="
                + departDate + ", departTime=" + departTime + ", arrivalDate=" + arrivalDate + ", arrivalTime="
                + arrivalTime + ", economyFare=" + economyFare + ", businessFare=" + businessFare + ", firstClassFare="
                + firstClassFare + ", company=" + company + ", flightType=" + flightType + ", timeTaken=" + timeTaken
                + ", seatsAvailable=" + seatsAvailable + "]";
    }
}