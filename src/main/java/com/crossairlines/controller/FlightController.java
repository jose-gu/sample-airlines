package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crossairlines.dto.FlightRequestDTO;
import com.crossairlines.dto.FlightResponseDTO;
import com.crossairlines.service.FlightService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightResponseDTO> addFlight(@Valid @RequestBody FlightRequestDTO flightRequestDTO) {
        FlightResponseDTO response = flightService.addFlight(flightRequestDTO);
        return ResponseEntity.ok(response);
    }
}