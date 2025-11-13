package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<String> addFlight(@Valid @RequestBody FlightDto flightDto) {
        try {
            flightService.addFlight(flightDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Flight added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding flight: " + e.getMessage());
        }
    }
}