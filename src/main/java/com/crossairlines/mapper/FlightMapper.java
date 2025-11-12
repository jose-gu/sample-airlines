package com.crossairlines.mapper;

import com.crossairlines.dto.FlightCreateRequest;
import com.crossairlines.dto.FlightDetailsDto;
import com.crossairlines.dto.FlightUpdateRequest;
import com.crossairlines.model.FlightDetails;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    
    public FlightDetailsDto toDto(FlightDetails entity) {
        if (entity == null) {
            return null;
        }
        
        FlightDetailsDto dto = new FlightDetailsDto();
        dto.setFlightDetailsId(entity.getFlightDetailsId());
        dto.setFromCountry(entity.getFromCountry());
        dto.setDestCountry(entity.getDestCountry());
        dto.setOriginCity(entity.getOriginCity());
        dto.setDestinationCity(entity.getDestinationCity());
        dto.setOriginAirport(entity.getOriginAirport());
        dto.setDestinationAirport(entity.getDestinationAirport());
        dto.setDepartDate(entity.getDepartDate());
        dto.setArrivalDate(entity.getArrivalDate());
        dto.setDepartTime(entity.getDepartTime());
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
    
    public FlightDetails toEntity(FlightDetailsDto dto) {
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
        entity.setArrivalDate(dto.getArrivalDate());
        entity.setDepartTime(dto.getDepartTime());
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
    
    public FlightDetails toCreateEntity(FlightCreateRequest request) {
        if (request == null) {
            return null;
        }
        
        FlightDetails entity = new FlightDetails();
        entity.setFromCountry(request.getFromCountry());
        entity.setDestCountry(request.getDestCountry());
        entity.setOriginCity(request.getOriginCity());
        entity.setDestinationCity(request.getDestinationCity());
        entity.setOriginAirport(request.getOriginAirport());
        entity.setDestinationAirport(request.getDestinationAirport());
        entity.setDepartDate(request.getDepartDate());
        entity.setArrivalDate(request.getArrivalDate());
        entity.setDepartTime(request.getDepartTime());
        entity.setArrivalTime(request.getArrivalTime());
        entity.setEconomyFare(request.getEconomyFare());
        entity.setBusinessFare(request.getBusinessFare());
        entity.setFirstClassFare(request.getFirstClassFare());
        entity.setCompany(request.getCompany());
        entity.setFlightType(request.getFlightType());
        entity.setTimeTaken(request.getTimeTaken());
        entity.setSeatsAvailable(request.getSeatsAvailable());
        return entity;
    }
    
    public FlightDetails toUpdateEntity(FlightDetails existingEntity, FlightUpdateRequest request) {
        if (request == null || existingEntity == null) {
            return existingEntity;
        }
        
        request.getFromCountry().ifPresent(existingEntity::setFromCountry);
        request.getDestCountry().ifPresent(existingEntity::setDestCountry);
        request.getOriginCity().ifPresent(existingEntity::setOriginCity);
        request.getDestinationCity().ifPresent(existingEntity::setDestinationCity);
        request.getOriginAirport().ifPresent(existingEntity::setOriginAirport);
        request.getDestinationAirport().ifPresent(existingEntity::setDestinationAirport);
        request.getDepartDate().ifPresent(existingEntity::setDepartDate);
        request.getArrivalDate().ifPresent(existingEntity::setArrivalDate);
        request.getDepartTime().ifPresent(existingEntity::setDepartTime);
        request.getArrivalTime().ifPresent(existingEntity::setArrivalTime);
        request.getEconomyFare().ifPresent(existingEntity::setEconomyFare);
        request.getBusinessFare().ifPresent(existingEntity::setBusinessFare);
        request.getFirstClassFare().ifPresent(existingEntity::setFirstClassFare);
        request.getCompany().ifPresent(existingEntity::setCompany);
        request.getFlightType().ifPresent(existingEntity::setFlightType);
        request.getTimeTaken().ifPresent(existingEntity::setTimeTaken);
        request.getSeatsAvailable().ifPresent(existingEntity::setSeatsAvailable);
        
        return existingEntity;
    }
}