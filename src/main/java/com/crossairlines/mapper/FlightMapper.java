package com.crossairlines.mapper;

import org.springframework.stereotype.Component;
import com.crossairlines.dto.FlightDto;
import com.crossairlines.model.FlightDetails;

@Component
public class FlightMapper {
    
    public FlightDto toDto(FlightDetails entity) {
        if (entity == null) {
            return null;
        }
        
        FlightDto dto = new FlightDto();
        dto.setFlightDetailsId(entity.getFlightDetailsId());
        dto.setOriginCity(entity.getOriginCity());
        dto.setDestinationCity(entity.getDestinationCity());
        dto.setOriginAirport(entity.getOriginAirport());
        dto.setDestinationAirport(entity.getDestinationAirport());
        dto.setDepartDate(entity.getDepartDate());
        dto.setDepartTime(entity.getDepartTime());
        dto.setArrivalTime(entity.getArrivalTime());
        dto.setEconomyFare(entity.getEconomyFare());
        dto.setBusinessFare(entity.getBusinessFare());
        dto.setFirstClassFare(entity.getFirstClassFare());
        dto.setCompany(entity.getCompany());
        dto.setSeatsAvailable(entity.getSeatsAvailabe());
        
        return dto;
    }
    
    public FlightDetails toEntity(FlightDto dto) {
        if (dto == null) {
            return null;
        }
        
        FlightDetails entity = new FlightDetails();
        entity.setFlightDetailsId(dto.getFlightDetailsId());
        entity.setOriginCity(dto.getOriginCity());
        entity.setDestinationCity(dto.getDestinationCity());
        entity.setOriginAirport(dto.getOriginAirport());
        entity.setDestinationAirport(dto.getDestinationAirport());
        entity.setDepartDate(dto.getDepartDate());
        entity.setDepartTime(dto.getDepartTime());
        entity.setArrivalTime(dto.getArrivalTime());
        entity.setEconomyFare(dto.getEconomyFare());
        entity.setBusinessFare(dto.getBusinessFare());
        entity.setFirstClassFare(dto.getFirstClassFare());
        entity.setCompany(dto.getCompany());
        entity.setSeatsAvailabe(dto.getSeatsAvailable());
        
        return entity;
    }
}