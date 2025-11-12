package com.crossairlines.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight_details")
public class FlightDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_details_id")
    private Integer flightDetailsId;
    
    @Column(name = "from_country", nullable = false)
    private String fromCountry;
    
    @Column(name = "dest_country", nullable = false)
    private String destCountry;
    
    @Column(name = "origin_city", nullable = false)
    private String originCity;
    
    @Column(name = "destination_city", nullable = false)
    private String destinationCity;
    
    @Column(name = "origin_airport", nullable = false)
    private String originAirport;
    
    @Column(name = "destination_airport", nullable = false)
    private String destinationAirport;
    
    @Column(name = "depart_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date departDate;
    
    @Column(name = "arrival_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    
    @Column(name = "depart_time", nullable = false)
    private String departTime;
    
    @Column(name = "arrival_time", nullable = false)
    private String arrivalTime;
    
    @Column(name = "economy_fare", nullable = false)
    private Double economyFare;
    
    @Column(name = "business_fare", nullable = false)
    private Double businessFare;
    
    @Column(name = "first_class_fare", nullable = false)
    private Double firstClassFare;
    
    @Column(name = "company", nullable = false)
    private String company;
    
    @Column(name = "flight_type", nullable = false)
    private String flightType;
    
    @Column(name = "time_taken")
    private Double timeTaken;
    
    @Column(name = "seats_available", nullable = false)
    private Integer seatsAvailable = 100;
    
    public FlightDetails() {}
    
    public Integer getFlightDetailsId() {
        return flightDetailsId;
    }
    
    public void setFlightDetailsId(Integer flightDetailsId) {
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