package com.crossairlines.controller;

import com.crossairlines.dto.FlightCreateDTO;
import com.crossairlines.dto.FlightDTO;
import com.crossairlines.dto.FlightUpdateDTO;
import com.crossairlines.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightDTO> addFlight(@Valid @RequestBody FlightCreateDTO flightCreateDTO) {
        FlightDTO createdFlight = flightService.createFlight(flightCreateDTO);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Long id, @Valid @RequestBody FlightUpdateDTO flightUpdateDTO) {
        FlightDTO updatedFlight = flightService.updateFlight(id, flightUpdateDTO);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.removeFlight(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        List<FlightDTO> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
        FlightDTO flight = flightService.getFlightById(id);
        return ResponseEntity.ok(flight);
    }
}