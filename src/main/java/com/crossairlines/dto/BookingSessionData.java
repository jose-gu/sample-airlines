package com.crossairlines.dto;

public class BookingSessionData {
    
    private BookTicketData bookTicketData;
    private FlightDetailsData flightDetailsData;
    private Long userId;
    
    public BookTicketData getBookTicketData() {
        return bookTicketData;
    }
    
    public void setBookTicketData(BookTicketData bookTicketData) {
        this.bookTicketData = bookTicketData;
    }
    
    public FlightDetailsData getFlightDetailsData() {
        return flightDetailsData;
    }
    
    public void setFlightDetailsData(FlightDetailsData flightDetailsData) {
        this.flightDetailsData = flightDetailsData;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public static class BookTicketData {
        private Integer adultCount;
        private Integer childCount;
        private Integer finalFare;
        private String classType;
        
        public Integer getAdultCount() {
            return adultCount;
        }
        
        public void setAdultCount(Integer adultCount) {
            this.adultCount = adultCount;
        }
        
        public Integer getChildCount() {
            return childCount;
        }
        
        public void setChildCount(Integer childCount) {
            this.childCount = childCount;
        }
        
        public Integer getFinalFare() {
            return finalFare;
        }
        
        public void setFinalFare(Integer finalFare) {
            this.finalFare = finalFare;
        }
        
        public String getClassType() {
            return classType;
        }
        
        public void setClassType(String classType) {
            this.classType = classType;
        }
    }
    
    public static class FlightDetailsData {
        private Long flightDetailsId;
        
        public Long getFlightDetailsId() {
            return flightDetailsId;
        }
        
        public void setFlightDetailsId(Long flightDetailsId) {
            this.flightDetailsId = flightDetailsId;
        }
    }
}