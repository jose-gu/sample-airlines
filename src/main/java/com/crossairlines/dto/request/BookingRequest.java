package com.crossairlines.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

public class BookingRequest {
    
    @NotNull(message = "Flight ID is required")
    @Min(value = 1, message = "Flight ID must be positive")
    private Integer id;
    
    @Min(value = 1, message = "Adult count must be at least 1")
    @Max(value = 6, message = "Adult count cannot exceed 6")
    private int adultCount;
    
    @Min(value = 0, message = "Child count cannot be negative")
    private int childCount;
    
    @Min(value = 0, message = "Final fare cannot be negative")
    private int finalFare;
    
    @NotBlank(message = "Class type is required")
    private String classType;
    
    public BookingRequest() {}
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
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
        return "BookingRequest [id=" + id + ", adultCount=" + adultCount + ", childCount=" + childCount + ", finalFare="
                + finalFare + ", classType=" + classType + "]";
    }
}