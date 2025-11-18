package com.crossairlines.model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "card_number")
    private String cardNumber;
    
    @Column(name = "card_holder_name")
    private String cardHolderName;
    
    @Column(name = "expiry_date")
    private String expiryDate;
    
    @Column(name = "cvv_no")
    private String cvvNo;
    
    @Column(name = "amount")
    private Integer amount;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BookingRecord bookTicket;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public String getCardHolderName() {
        return cardHolderName;
    }
    
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
    
    public String getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public String getCvvNo() {
        return cvvNo;
    }
    
    public void setCvvNo(String cvvNo) {
        this.cvvNo = cvvNo;
    }
    
    public Integer getAmount() {
        return amount;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    public UserEntity getUser() {
        return user;
    }
    
    public void setUser(UserEntity user) {
        this.user = user;
    }
    
    public BookingRecord getBookTicket() {
        return bookTicket;
    }
    
    public void setBookTicket(BookingRecord bookTicket) {
        this.bookTicket = bookTicket;
    }
}