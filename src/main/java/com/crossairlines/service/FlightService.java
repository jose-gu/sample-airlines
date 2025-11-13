package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossairlines.dto.FlightRequestDto;
import com.crossairlines.dto.FlightResponseDto;
import com.crossairlines.mapper.FlightMapper;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightMapper flightMapper;

    @Transactional
    public FlightResponseDto addFlight(FlightRequestDto flightRequestDto) {
        System.out.println(flightRequestDto);
        FlightDetails flightDetails = flightMapper.toEntity(flightRequestDto);
        System.out.println(flightDetails);
        FlightDetails savedFlight = flightRepository.save(flightDetails);
        return flightMapper.toResponseDto(savedFlight);
    }
}