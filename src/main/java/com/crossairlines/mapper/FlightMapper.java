package com.crossairlines.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.crossairlines.dto.FlightDto;
import com.crossairlines.model.FlightEntity;

public class FlightMapper {
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    public static FlightEntity toEntity(FlightDto dto) {
        if (dto == null) {
            return null;
        }
        
        FlightEntity entity = new FlightEntity();
        entity.setFlightDetailsId(dto.getFlightDetailsId());
        entity.setFromCountry(dto.getFromCountry());
        entity.setDestCountry(dto.getDestCountry());
        entity.setOriginCity(dto.getOriginCity());
        entity.setDestinationCity(dto.getDestinationCity());
        entity.setOriginAirport(dto.getOriginAirport());
        entity.setDestinationAirport(dto.getDestinationAirport());
        
        // Parse departure date
        if (dto.getDepartDatet() != null) {
            try {
                Date departDate = DATE_FORMAT.parse(dto.getDepartDatet());
                entity.setDepartDate(departDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        entity.setDepartTime(dto.getDepartTime());
        
        // Parse arrival date
        if (dto.getArrivalDatet() != null) {
            try {
                Date arrivalDate = DATE_FORMAT.parse(dto.getArrivalDatet());
                entity.setArrivalDate(arrivalDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        entity.setArrivalTime(dto.getArrivalTime());
        entity.setEconomyFare(dto.getEconomyFare());
        entity.setBusinessFare(dto.getBusinessFare());
        entity.setFirstClassFare(dto.getFirstClassFare());
        entity.setCompany(dto.getCompany());
        entity.setFlightType(dto.getFlightType());
        entity.setTimeTaken(dto.getTimeTaken());
        entity.setSeatsAvailable(dto.getSeatsAvailable());
        
        return entity;
    }
    
    public static FlightDto toDto(FlightEntity entity) {
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
        
        // Format departure date
        if (entity.getDepartDate() != null) {
            dto.setDepartDatet(DATE_FORMAT.format(entity.getDepartDate()));
        }
        
        dto.setDepartTime(entity.getDepartTime());
        
        // Format arrival date
        if (entity.getArrivalDate() != null) {
            dto.setArrivalDatet(DATE_FORMAT.format(entity.getArrivalDate()));
        }
        
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