package com.crossairlines.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    
    private String message;
    private LocalDateTime timestamp;
    private int status;

    // Default constructor
    public ErrorResponse() {}

    // Constructor with parameters
    public ErrorResponse(String message, LocalDateTime timestamp, int status) {
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ErrorResponse [message=" + message + ", timestamp=" + timestamp + ", status=" + status + "]";
    }
}