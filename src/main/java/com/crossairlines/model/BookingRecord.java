package com.crossairlines.model;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class BookingRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "adult_count")
    private Integer adultCount;
    
    @Column(name = "child_count")
    private Integer childCount;
    
    @Column(name = "final_fare")
    private Integer finalFare;
    
    @Column(name = "class_type")
    private String classType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_details_id")
    private FlightEntity flightDetails;
    
    public BookingRecord() {}
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public UserEntity getUser() {
        return user;
    }
    
    public void setUser(UserEntity user) {
        this.user = user;
    }
    
    public PaymentEntity getPayment() {
        return payment;
    }
    
    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }
    
    public FlightEntity getFlightDetails() {
        return flightDetails;
    }
    
    public void setFlightDetails(FlightEntity flightDetails) {
        this.flightDetails = flightDetails;
    }
    
    public FlightEntity getFlightEntity() {
        return flightDetails;
    }
    
    public void setFlightEntity(FlightEntity flightEntity) {
        this.flightDetails = flightEntity;
    }
}