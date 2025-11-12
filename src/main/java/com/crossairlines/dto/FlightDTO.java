package com.crossairlines.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class FlightDTO {
    private Long flightDetailsId;
    private String fromCountry;
    private String destinationCountry;
    private String originCity;
    private String destinationCity;
    private String originAirport;
    private String destinationAirport;
    private LocalDateTime departDate;
    private LocalDateTime arrivalDate;
    private String company;
    private String flightType;
    private Map<String, Double> fares;
    private Integer seatsAvailable;
    private Double timeTaken;

    public FlightDTO() {}

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

    public Map<String, Double> getFares() {
        return fares;
    }

    public void setFares(Map<String, Double> fares) {
        this.fares = fares;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public Double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Double timeTaken) {
        this.timeTaken = timeTaken;
    }
}