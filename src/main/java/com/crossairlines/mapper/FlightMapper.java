package com.crossairlines.mapper;

import org.springframework.stereotype.Component;

import com.crossairlines.dto.FlightRequestDto;
import com.crossairlines.dto.FlightResponseDto;
import com.crossairlines.model.FlightDetails;

@Component
public class FlightMapper {

    public FlightDetails toEntity(FlightRequestDto requestDto) {
        FlightDetails flightDetails = new FlightDetails();
        
        flightDetails.setFromCountry(requestDto.getFromCountry());
        flightDetails.setDestCountry(requestDto.getDestCountry());
        flightDetails.setOriginCity(requestDto.getOriginCity());
        flightDetails.setDestinationCity(requestDto.getDestinationCity());
        flightDetails.setOriginAirport(requestDto.getOriginAirport());
        flightDetails.setDestinationAirport(requestDto.getDestinationAirport());
        flightDetails.setDepartDate(requestDto.getDepartDate());
        flightDetails.setDepartTime(requestDto.getDepartTime());
        flightDetails.setArrivalDate(requestDto.getArrivalDate());
        flightDetails.setArrivalTime(requestDto.getArrivalTime());
        flightDetails.setEconomyFare(requestDto.getEconomyFare());
        flightDetails.setBusinessFare(requestDto.getBusinessFare());
        flightDetails.setFirstClassFare(requestDto.getFirstClassFare());
        flightDetails.setCompany(requestDto.getCompany());
        flightDetails.setFlightType(requestDto.getFlightType());
        flightDetails.setTimeTaken(requestDto.getTimeTaken());
        flightDetails.setSeatsAvailabe(requestDto.getSeatsAvailabe());
        
        return flightDetails;
    }

    public FlightResponseDto toResponseDto(FlightDetails flightDetails) {
        FlightResponseDto responseDto = new FlightResponseDto();
        
        responseDto.setFlightDetailsId(flightDetails.getFlightDetailsId());
        responseDto.setMessage("Flight added successfully");
        responseDto.setStatus("SUCCESS");
        
        return responseDto;
    }
}