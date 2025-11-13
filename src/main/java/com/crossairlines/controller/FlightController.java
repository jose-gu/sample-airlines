package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crossairlines.dto.ApiResponse;
import com.crossairlines.dto.FlightDto;
import com.crossairlines.service.FlightService;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<ApiResponse<FlightDto>> addFlight(@Valid @RequestBody FlightDto flightDto) {
        try {
            FlightDto savedFlight = flightService.addFlight(flightDto);
            ApiResponse<FlightDto> response = new ApiResponse<>(true, "Flight added successfully", savedFlight, LocalDateTime.now());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse<FlightDto> response = new ApiResponse<>(false, "Error adding flight: " + e.getMessage(), null, LocalDateTime.now());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}