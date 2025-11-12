package com.crossairlines.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight_details")
public class Flight {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_details_id")
    private Long flightDetailsId;
    
    @Column(name = "from_country", nullable = false)
    private String fromCountry;
    
    @Column(name = "destination_country", nullable = false)
    private String destinationCountry;
    
    @Column(name = "origin_city", nullable = false)
    private String originCity;
    
    @Column(name = "destination_city", nullable = false)
    private String destinationCity;
    
    @Column(name = "origin_airport", nullable = false)
    private String originAirport;
    
    @Column(name = "destination_airport", nullable = false)
    private String destinationAirport;
    
    @Column(name = "depart_date", nullable = false)
    private LocalDateTime departDate;
    
    @Column(name = "arrival_date", nullable = false)
    private LocalDateTime arrivalDate;
    
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
    
    @Column(name = "seats_available")
    private Integer seatsAvailable = 100;

    public Flight() {}

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