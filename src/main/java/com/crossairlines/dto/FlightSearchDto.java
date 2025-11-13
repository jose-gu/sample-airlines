package com.crossairlines.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Date;

public class FlightSearchDto {
    
    public static class FlightSearchRequest {
        
        private String flightType;
        
        @NotBlank(message = "Origin is required")
        private String origin;
        
        @NotBlank(message = "Destination is required")
        private String destination;
        
        @NotBlank(message = "Departure date is required")
        private String departDate;
        
        private String returnDate;
        
        private String multicity;
        
        // Getters and Setters
        public String getFlightType() {
            return flightType;
        }
        
        public void setFlightType(String flightType) {
            this.flightType = flightType;
        }
        
        public String getOrigin() {
            return origin;
        }
        
        public void setOrigin(String origin) {
            this.origin = origin;
        }
        
        public String getDestination() {
            return destination;
        }
        
        public void setDestination(String destination) {
            this.destination = destination;
        }
        
        public String getDepartDate() {
            return departDate;
        }
        
        public void setDepartDate(String departDate) {
            this.departDate = departDate;
        }
        
        public String getReturnDate() {
            return returnDate;
        }
        
        public void setReturnDate(String returnDate) {
            this.returnDate = returnDate;
        }
        
        public String getMulticity() {
            return multicity;
        }
        
        public void setMulticity(String multicity) {
            this.multicity = multicity;
        }
        
        @Override
        public String toString() {
            return "FlightSearchRequest [flightType=" + flightType + ", origin=" + origin + ", destination=" + destination
                    + ", departDate=" + departDate + ", returnDate=" + returnDate + ", multicity=" + multicity + "]";
        }
    }
    
    public static class FlightSearchResponse {
        
        private List<FlightDto> matchedFlights;
        private List<FlightDto> alternativeFlights;
        private FlightSearchRequest searchCriteria;
        
        // Getters and Setters
        public List<FlightDto> getMatchedFlights() {
            return matchedFlights;
        }
        
        public void setMatchedFlights(List<FlightDto> matchedFlights) {
            this.matchedFlights = matchedFlights;
        }
        
        public List<FlightDto> getAlternativeFlights() {
            return alternativeFlights;
        }
        
        public void setAlternativeFlights(List<FlightDto> alternativeFlights) {
            this.alternativeFlights = alternativeFlights;
        }
        
        public FlightSearchRequest getSearchCriteria() {
            return searchCriteria;
        }
        
        public void setSearchCriteria(FlightSearchRequest searchCriteria) {
            this.searchCriteria = searchCriteria;
        }
    }
    
    public static class FlightDto {
        
        private int flightDetailsId;
        private String company;
        private String originCity;
        private String destinationCity;
        private Date departDate;
        private String departTime;
        private double economyFare;
        private double businessFare;
        private double firstClassFare;
        
        // Getters and Setters
        public int getFlightDetailsId() {
            return flightDetailsId;
        }
        
        public void setFlightDetailsId(int flightDetailsId) {
            this.flightDetailsId = flightDetailsId;
        }
        
        public String getCompany() {
            return company;
        }
        
        public void setCompany(String company) {
            this.company = company;
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
    }
}