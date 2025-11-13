package com.crossairlines.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BookingDto {
    
    public static class BookTicketDto {
        
        @NotNull(message = "Flight ID is required")
        @Min(value = 1, message = "Flight ID must be greater than 0")
        private int id;
        
        @Min(value = 0, message = "Adult count cannot be negative")
        private int adultCount;
        
        @Min(value = 0, message = "Child count cannot be negative")
        private int childCount;
        
        @Min(value = 0, message = "Final fare cannot be negative")
        private int finalFare;
        
        private String classType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdultCount() {
            return adultCount;
        }

        public void setAdultCount(int adultCount) {
            this.adultCount = adultCount;
        }

        public int getChildCount() {
            return childCount;
        }

        public void setChildCount(int childCount) {
            this.childCount = childCount;
        }

        public int getFinalFare() {
            return finalFare;
        }

        public void setFinalFare(int finalFare) {
            this.finalFare = finalFare;
        }

        public String getClassType() {
            return classType;
        }

        public void setClassType(String classType) {
            this.classType = classType;
        }

        @Override
        public String toString() {
            return "BookTicketDto [id=" + id + ", adultCount=" + adultCount + ", childCount=" + childCount + ", finalFare="
                    + finalFare + ", classType=" + classType + "]";
        }
    }
    
    public static class BookingResponse {
        
        private String redirectUrl;
        private FlightDetailsDto flightDetails;
        private boolean requiresLogin;
        private String message;

        public String getRedirectUrl() {
            return redirectUrl;
        }

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }

        public FlightDetailsDto getFlightDetails() {
            return flightDetails;
        }

        public void setFlightDetails(FlightDetailsDto flightDetails) {
            this.flightDetails = flightDetails;
        }

        public boolean isRequiresLogin() {
            return requiresLogin;
        }

        public void setRequiresLogin(boolean requiresLogin) {
            this.requiresLogin = requiresLogin;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "BookingResponse [redirectUrl=" + redirectUrl + ", flightDetails=" + flightDetails + ", requiresLogin="
                    + requiresLogin + ", message=" + message + "]";
        }
    }
}