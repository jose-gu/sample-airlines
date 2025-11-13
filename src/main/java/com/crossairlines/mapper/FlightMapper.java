package com.crossairlines.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.model.Flight;

@Component
public class FlightMapper {

    public Flight toEntity(FlightDto flightDto) {
        Flight flight = new Flight();
        BeanUtils.copyProperties(flightDto, flight);
        return flight;
    }

    public FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        BeanUtils.copyProperties(flight, flightDto);
        return flightDto;
    }
}