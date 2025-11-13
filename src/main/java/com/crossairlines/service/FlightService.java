package com.crossairlines.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.model.FlightEntity;
import com.crossairlines.repository.FlightRepository;
import com.crossairlines.mapper.FlightMapper;

@Service
@Transactional
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void addFlight(FlightDto flightDto) {
        System.out.println(flightDto);
        FlightEntity flightEntity = FlightMapper.toEntity(flightDto);
        System.out.println(flightEntity);
        flightRepository.save(flightEntity);
    }
}