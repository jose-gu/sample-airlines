package com.crossairlines.mapper;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.model.FlightDetails;

public class FlightMapper {

    public static FlightDetails toEntity(FlightDto dto) {
        if (dto == null) {
            return null;
        }
        
        FlightDetails entity = new FlightDetails();
        entity.setFlightDetailsId(dto.getFlightDetailsId());
        entity.setFromCountry(dto.getFromCountry());
        entity.setDestCountry(dto.getDestCountry());
        entity.setOriginCity(dto.getOriginCity());
        entity.setDestinationCity(dto.getDestinationCity());
        entity.setOriginAirport(dto.getOriginAirport());
        entity.setDestinationAirport(dto.getDestinationAirport());
        entity.setDepartDate(dto.getDepartDate());
        entity.setDepartTime(dto.getDepartTime());
        entity.setArrivalDate(dto.getArrivalDate());
        entity.setArrivalTime(dto.getArrivalTime());
        entity.setEconomyFare(dto.getEconomyFare());
        entity.setBusinessFare(dto.getBusinessFare());
        entity.setFirstClassFare(dto.getFirstClassFare());
        entity.setCompany(dto.getCompany());
        entity.setFlightType(dto.getFlightType());
        entity.setTimeTaken(dto.getTimeTaken());
        entity.setSeatsAvailabe(dto.getSeatsAvailabe());
        
        return entity;
    }

    public static FlightDto toDto(FlightDetails entity) {
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
        dto.setSeatsAvailabe(entity.getSeatsAvailabe());
        
        return dto;
    }
}