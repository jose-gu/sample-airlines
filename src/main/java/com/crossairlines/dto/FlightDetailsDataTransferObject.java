package com.crossairlines.dto;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Time;

public class FlightDetailsDataTransferObject {
    
    private Integer flightDetailsId;
    private String originCity;
    private String destinationCity;
    private String originAirport;
    private String destinationAirport;
    private Date departDate;
    private LocalDate departDateLocal;
    private String departTime;
    private LocalTime departTimeLocal;
    private Time departTimeSql;
    private Date arrivalDate;
    private String arrivalTime;
    private LocalTime arrivalTimeLocal;
    private Time arrivalTimeSql;
    private String company;
    private String flightType;
    private double economyFare;
    private double businessFare;
    private double firstClassFare;
    private String fares;
    private double timeTaken;
    
    public FlightDetailsDataTransferObject() {}
    
    public Integer getFlightDetailsId() {
        return flightDetailsId;
    }
    
    public void setFlightDetailsId(Integer flightDetailsId) {
        this.flightDetailsId = flightDetailsId;
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
    
    public LocalDate getDepartDateLocal() {
        return departDateLocal;
    }
    
    public void setDepartDateLocal(LocalDate departDateLocal) {
        this.departDateLocal = departDateLocal;
    }
    
    public String getDepartTime() {
        return departTime;
    }
    
    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }
    
    public LocalTime getDepartTimeLocal() {
        return departTimeLocal;
    }
    
    public void setDepartTimeLocal(LocalTime departTimeLocal) {
        this.departTimeLocal = departTimeLocal;
    }
    
    public Time getDepartTimeSql() {
        return departTimeSql;
    }
    
    public void setDepartTimeSql(Time departTimeSql) {
        this.departTimeSql = departTimeSql;
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
    
    public LocalTime getArrivalTimeLocal() {
        return arrivalTimeLocal;
    }
    
    public void setArrivalTimeLocal(LocalTime arrivalTimeLocal) {
        this.arrivalTimeLocal = arrivalTimeLocal;
    }
    
    public Time getArrivalTimeSql() {
        return arrivalTimeSql;
    }
    
    public void setArrivalTimeSql(Time arrivalTimeSql) {
        this.arrivalTimeSql = arrivalTimeSql;
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
    
    public String getFares() {
        return fares;
    }
    
    public void setFares(String fares) {
        this.fares = fares;
    }
    
    public double getTimeTaken() {
        return timeTaken;
    }
    
    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }
    
    @Override
    public String toString() {
        return "FlightDetailsDataTransferObject [flightDetailsId=" + flightDetailsId + ", originCity=" + originCity
                + ", destinationCity=" + destinationCity + ", departDate=" + departDate + ", company=" + company
                + ", fares=" + fares + "]";
    }
}