package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossairlines.dto.FlightRequestDTO;
import com.crossairlines.dto.FlightResponseDTO;
import com.crossairlines.mapper.FlightMapper;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.repository.FlightRepository;

@Service
@Transactional
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public FlightResponseDTO addFlight(FlightRequestDTO flightRequestDTO) {
        FlightDetails flightDetails = FlightMapper.toEntity(flightRequestDTO);
        FlightDetails savedFlight = flightRepository.save(flightDetails);
        return FlightMapper.toResponseDTO(savedFlight);
    }
}