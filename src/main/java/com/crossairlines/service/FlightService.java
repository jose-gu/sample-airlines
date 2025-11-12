package com.crossairlines.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void addFlight(FlightDto flightDto) {
        FlightDetails flightDetails = new FlightDetails();
        BeanUtils.copyProperties(flightDto, flightDetails);
        System.out.println(flightDetails);
        flightRepository.save(flightDetails);
    }
}