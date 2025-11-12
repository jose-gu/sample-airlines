package com.crossairlines.service;

import com.crossairlines.dto.FlightCreateDTO;
import com.crossairlines.dto.FlightDTO;
import com.crossairlines.dto.FlightUpdateDTO;

import java.util.List;

public interface FlightService {
    FlightDTO createFlight(FlightCreateDTO flightCreateDTO);
    FlightDTO updateFlight(Long id, FlightUpdateDTO flightUpdateDTO);
    void removeFlight(Long id);
    List<FlightDTO> getAllFlights();
    FlightDTO getFlightById(Long id);
    void validateFlightData(FlightCreateDTO flightCreateDTO);
}