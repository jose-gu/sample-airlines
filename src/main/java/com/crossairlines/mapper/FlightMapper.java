package com.crossairlines.mapper;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.model.Flight;

public class FlightMapper {
    
    public static Flight toEntity(FlightDto dto) {
        if (dto == null) {
            return null;
        }
        
        Flight flight = new Flight();
        flight.setFlightDetailsId(dto.getFlightDetailsId());
        flight.setFromCountry(dto.getFromCountry());
        flight.setDestCountry(dto.getDestCountry());
        flight.setOriginCity(dto.getOriginCity());
        flight.setDestinationCity(dto.getDestinationCity());
        flight.setOriginAirport(dto.getOriginAirport());
        flight.setDestinationAirport(dto.getDestinationAirport());
        flight.setDepartDate(dto.getDepartDate());
        flight.setDepartTime(dto.getDepartTime());
        flight.setArrivalDate(dto.getArrivalDate());
        flight.setArrivalTime(dto.getArrivalTime());
        flight.setEconomyFare(dto.getEconomyFare());
        flight.setBusinessFare(dto.getBusinessFare());
        flight.setFirstClassFare(dto.getFirstClassFare());
        flight.setCompany(dto.getCompany());
        flight.setFlightType(dto.getFlightType());
        flight.setTimeTaken(dto.getTimeTaken());
        flight.setSeatsAvailable(dto.getSeatsAvailable());
        
        return flight;
    }
    
    public static FlightDto toDto(Flight entity) {
        if (entity == null) {
            return null;
        }
        
        FlightDto dto = new FlightDto();
        dto.setFlightDetailsId(entity.getFlightDetailsId());
        dto.setFromCountry(entity.getFromCountry());
        dto.setDestCountry(entity.getDestCountry());
        dto.setOriginCity(entity.getOriginCity());
        dto.setDestinationCity(entity.getDestinationCity());
        dto.setOriginAirport(entity.getOriginAirport());
        dto.setDestinationAirport(entity.getDestinationAirport());
        dto.setDepartDate(entity.getDepartDate());
        dto.setDepartTime(entity.getDepartTime());
        dto.setArrivalDate(entity.getArrivalDate());
        dto.setArrivalTime(entity.getArrivalTime());
        dto.setEconomyFare(entity.getEconomyFare());
        dto.setBusinessFare(entity.getBusinessFare());
        dto.setFirstClassFare(entity.getFirstClassFare());
        dto.setCompany(entity.getCompany());
        dto.setFlightType(entity.getFlightType());
        dto.setTimeTaken(entity.getTimeTaken());
        dto.setSeatsAvailable(entity.getSeatsAvailable());
        
        return dto;
    }
}