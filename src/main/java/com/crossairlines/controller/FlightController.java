package com.crossairlines.controller;

import com.crossairlines.dto.FlightCreateRequest;
import com.crossairlines.dto.FlightDetailsDto;
import com.crossairlines.dto.FlightUpdateRequest;
import com.crossairlines.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/flights")
public class FlightController {
    
    private final FlightService flightService;
    
    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    
    @PostMapping
    public ResponseEntity<FlightDetailsDto> createFlight(@Valid @RequestBody FlightCreateRequest request) {
        FlightDetailsDto createdFlight = flightService.createFlight(request);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }
    
    @PutMapping("/{flightId}")
    public ResponseEntity<FlightDetailsDto> updateFlight(@PathVariable Integer flightId, 
                                                        @Valid @RequestBody FlightUpdateRequest request) {
        request.setFlightDetailsId(flightId);
        FlightDetailsDto updatedFlight = flightService.updateFlight(request);
        return ResponseEntity.ok(updatedFlight);
    }
    
    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDetailsDto> getFlightById(@PathVariable Integer flightId) {
        FlightDetailsDto flight = flightService.getFlightById(flightId);
        return ResponseEntity.ok(flight);
    }
    
    @GetMapping
    public ResponseEntity<List<FlightDetailsDto>> getAllFlights() {
        List<FlightDetailsDto> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }
    
    @PatchMapping("/{flightId}/availability")
    public ResponseEntity<FlightDetailsDto> updateAvailability(@PathVariable Integer flightId, 
                                                              @RequestParam Integer seatsAvailable) {
        FlightDetailsDto updatedFlight = flightService.updateAvailability(flightId, seatsAvailable);
        return ResponseEntity.ok(updatedFlight);
    }
}