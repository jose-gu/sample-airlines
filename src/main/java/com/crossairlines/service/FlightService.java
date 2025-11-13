package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.mapper.FlightMapper;
import com.crossairlines.model.Flight;
import com.crossairlines.repository.FlightRepository;

@Service
public class FlightService {
    
    @Autowired
    private FlightRepository flightRepository;
    
    public void addFlight(FlightDto flightDto) {
        Flight flight = FlightMapper.toEntity(flightDto);
        flightRepository.save(flight);
    }
}