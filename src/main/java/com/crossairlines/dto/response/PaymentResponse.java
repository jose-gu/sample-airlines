package com.crossairlines.dto.response;

public class PaymentResponse {
    
    private Long bookingId;
    private String paymentStatus;
    private String confirmationNumber;
    private TicketDetails ticketDetails;
    
    public Long getBookingId() {
        return bookingId;
    }
    
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    public String getConfirmationNumber() {
        return confirmationNumber;
    }
    
    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
    
    public TicketDetails getTicketDetails() {
        return ticketDetails;
    }
    
    public void setTicketDetails(TicketDetails ticketDetails) {
        this.ticketDetails = ticketDetails;
    }
    
    public static class TicketDetails {
        private Integer adultCount;
        private Integer childCount;
        private Integer finalFare;
        private String classType;
        private String flightCompany;
        private String originCity;
        private String destinationCity;
        
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
        
        public String getFlightCompany() {
            return flightCompany;
        }
        
        public void setFlightCompany(String flightCompany) {
            this.flightCompany = flightCompany;
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
    }
}