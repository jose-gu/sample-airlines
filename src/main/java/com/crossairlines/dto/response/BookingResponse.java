package com.crossairlines.dto.response;

import com.crossairlines.dto.FlightDetailsDto;

public class BookingResponse {
    
    private Long bookingId;
    private FlightDetailsDto flightDetails;
    private Integer passengerCount;
    private Integer totalFare;
    private String classType;
    private String status;
    private String bookingStatus;
    private String redirectUrl;
    private boolean userAuthenticated;
    private boolean success;
    private String message;
    private FareBreakdown fareBreakdown;
    
    public BookingResponse() {}
    
    public Long getBookingId() {
        return bookingId;
    }
    
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    
    public FlightDetailsDto getFlightDetails() {
        return flightDetails;
    }
    
    public void setFlightDetails(FlightDetailsDto flightDetails) {
        this.flightDetails = flightDetails;
    }
    
    public Integer getPassengerCount() {
        return passengerCount;
    }
    
    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }
    
    public Integer getTotalFare() {
        return totalFare;
    }
    
    public void setTotalFare(Integer totalFare) {
        this.totalFare = totalFare;
    }
    
    public String getClassType() {
        return classType;
    }
    
    public void setClassType(String classType) {
        this.classType = classType;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getBookingStatus() {
        return bookingStatus;
    }
    
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
    public String getRedirectUrl() {
        return redirectUrl;
    }
    
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
    
    public boolean isUserAuthenticated() {
        return userAuthenticated;
    }
    
    public void setUserAuthenticated(boolean userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public FareBreakdown getFareBreakdown() {
        return fareBreakdown;
    }
    
    public void setFareBreakdown(FareBreakdown fareBreakdown) {
        this.fareBreakdown = fareBreakdown;
    }
    
    @Override
    public String toString() {
        return "BookingResponse [bookingId=" + bookingId + ", bookingStatus=" + bookingStatus + ", redirectUrl=" + redirectUrl
                + ", flightDetails=" + flightDetails + ", message=" + message + ", status=" + status + "]";
    }
    
    public static class FareBreakdown {
        private int adultCount;
        private int childCount;
        private int totalFare;
        private String classType;
        
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
        
        public int getTotalFare() {
            return totalFare;
        }
        
        public void setTotalFare(int totalFare) {
            this.totalFare = totalFare;
        }
        
        public String getClassType() {
            return classType;
        }
        
        public void setClassType(String classType) {
            this.classType = classType;
        }
    }
}