package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crossairlines.dto.ApiResponse;
import com.crossairlines.dto.FlightDto;
import com.crossairlines.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    
    @Autowired
    private FlightService flightService;
    
    @PostMapping
    public ResponseEntity<ApiResponse<String>> addFlight(@RequestBody FlightDto flightDto) {
        try {
            flightService.addFlight(flightDto);
            return ResponseEntity.ok(new ApiResponse<>(true, "Flight added successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Error adding flight: " + e.getMessage(), null));
        }
    }
}