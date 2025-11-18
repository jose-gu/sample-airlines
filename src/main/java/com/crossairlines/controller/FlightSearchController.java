package com.crossairlines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.crossairlines.service.FlightSearchService;
import com.crossairlines.dto.request.FlightSearchRequest;
import com.crossairlines.dto.response.FlightSearchResponse;

@RestController
@RequestMapping("/api/flights")
public class FlightSearchController {
    
    @Autowired
    private FlightSearchService flightSearchService;
    
    @PostMapping("/search")
    public ResponseEntity<FlightSearchResponse> searchFlights(@Valid @RequestBody FlightSearchRequest request) {
        FlightSearchResponse response = flightSearchService.searchFlights(request);
        return ResponseEntity.ok(response);
    }
}