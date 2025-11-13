package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.mapper.FlightMapper;
import com.crossairlines.model.Flight;
import com.crossairlines.repository.FlightRepository;

@Service
@Transactional
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightMapper flightMapper;

    public FlightDto addFlight(FlightDto flightDto) {
        Flight flight = flightMapper.toEntity(flightDto);
        Flight savedFlight = flightRepository.save(flight);
        return flightMapper.toDto(savedFlight);
    }
}