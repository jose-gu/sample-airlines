package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crossairlines.dto.FlightRequestDto;
import com.crossairlines.dto.FlightResponseDto;
import com.crossairlines.service.FlightService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightResponseDto> addFlight(@Valid @RequestBody FlightRequestDto flightRequestDto) {
        FlightResponseDto response = flightService.addFlight(flightRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}