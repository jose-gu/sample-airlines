package com.crossairlines.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import com.crossairlines.model.FlightDetails;

public class TicketBookingDto {
    
    public static class BookTicketRequest {
        
        @NotNull(message = "Flight ID is required")
        @Positive(message = "Flight ID must be positive")
        private Integer id;
        
        public Integer getId() {
            return id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        @Override
        public String toString() {
            return "BookTicketRequest [id=" + id + "]";
        }
    }
    
    public static class BookTicketResponse {
        
        private String redirectUrl;
        private String status;
        private FlightDetails flightDetails;
        
        public String getRedirectUrl() {
            return redirectUrl;
        }
        
        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }
        
        public String getStatus() {
            return status;
        }
        
        public void setStatus(String status) {
            this.status = status;
        }
        
        public FlightDetails getFlightDetails() {
            return flightDetails;
        }
        
        public void setFlightDetails(FlightDetails flightDetails) {
            this.flightDetails = flightDetails;
        }
    }
}