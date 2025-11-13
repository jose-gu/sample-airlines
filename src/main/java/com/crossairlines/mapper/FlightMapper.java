package com.crossairlines.mapper;

import com.crossairlines.dto.FlightRequestDTO;
import com.crossairlines.dto.FlightResponseDTO;
import com.crossairlines.model.FlightDetails;

public class FlightMapper {

    public static FlightDetails toEntity(FlightRequestDTO requestDTO) {
        FlightDetails flightDetails = new FlightDetails();
        
        flightDetails.setFromCountry(requestDTO.getFromCountry());
        flightDetails.setDestCountry(requestDTO.getDestCountry());
        flightDetails.setOriginCity(requestDTO.getOriginCity());
        flightDetails.setDestinationCity(requestDTO.getDestinationCity());
        flightDetails.setOriginAirport(requestDTO.getOriginAirport());
        flightDetails.setDestinationAirport(requestDTO.getDestinationAirport());
        flightDetails.setDepartDate(requestDTO.getDepartDate());
        flightDetails.setDepartTime(requestDTO.getDepartTime());
        flightDetails.setArrivalDate(requestDTO.getArrivalDate());
        flightDetails.setArrivalTime(requestDTO.getArrivalTime());
        flightDetails.setEconomyFare(requestDTO.getEconomyFare());
        flightDetails.setBusinessFare(requestDTO.getBusinessFare());
        flightDetails.setFirstClassFare(requestDTO.getFirstClassFare());
        flightDetails.setCompany(requestDTO.getCompany());
        flightDetails.setFlightType(requestDTO.getFlightType());
        flightDetails.setTimeTaken(requestDTO.getTimeTaken());
        flightDetails.setSeatsAvailable(requestDTO.getSeatsAvailable());
        
        return flightDetails;
    }

    public static FlightResponseDTO toResponseDTO(FlightDetails flightDetails) {
        FlightResponseDTO responseDTO = new FlightResponseDTO();
        
        responseDTO.setSuccess(true);
        responseDTO.setMessage("Flight added successfully");
        responseDTO.setFlightDetailsId(flightDetails.getFlightDetailsId());
        responseDTO.setFromCountry(flightDetails.getFromCountry());
        responseDTO.setDestCountry(flightDetails.getDestCountry());
        responseDTO.setOriginCity(flightDetails.getOriginCity());
        responseDTO.setDestinationCity(flightDetails.getDestinationCity());
        responseDTO.setOriginAirport(flightDetails.getOriginAirport());
        responseDTO.setDestinationAirport(flightDetails.getDestinationAirport());
        responseDTO.setDepartDate(flightDetails.getDepartDate());
        responseDTO.setDepartTime(flightDetails.getDepartTime());
        responseDTO.setArrivalDate(flightDetails.getArrivalDate());
        responseDTO.setArrivalTime(flightDetails.getArrivalTime());
        responseDTO.setEconomyFare(flightDetails.getEconomyFare());
        responseDTO.setBusinessFare(flightDetails.getBusinessFare());
        responseDTO.setFirstClassFare(flightDetails.getFirstClassFare());
        responseDTO.setCompany(flightDetails.getCompany());
        responseDTO.setFlightType(flightDetails.getFlightType());
        responseDTO.setTimeTaken(flightDetails.getTimeTaken());
        responseDTO.setSeatsAvailable(flightDetails.getSeatsAvailable());
        
        return responseDTO;
    }
}