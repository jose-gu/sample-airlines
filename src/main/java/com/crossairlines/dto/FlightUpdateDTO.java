package com.crossairlines.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

public class FlightUpdateDTO {
    
    @Future(message = "Departure date must be in the future")
    private LocalDateTime departDate;
    
    @Future(message = "Arrival date must be in the future")
    private LocalDateTime arrivalDate;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "Economy fare must be greater than 0")
    private Double economyFare;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "Business fare must be greater than 0")
    private Double businessFare;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "First class fare must be greater than 0")
    private Double firstClassFare;
    
    @Min(value = 0, message = "Seats available cannot be negative")
    private Integer seatsAvailable;
    
    private Double timeTaken;

    public FlightUpdateDTO() {}

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