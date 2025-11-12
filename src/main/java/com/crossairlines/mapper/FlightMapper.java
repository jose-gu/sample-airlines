package com.crossairlines.mapper;

import com.crossairlines.dto.FlightCreateDTO;
import com.crossairlines.dto.FlightDTO;
import com.crossairlines.dto.FlightUpdateDTO;
import com.crossairlines.model.Flight;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FlightMapper {

    public Flight toEntity(FlightCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Flight flight = new Flight();
        flight.setFromCountry(dto.getFromCountry());
        flight.setDestinationCountry(dto.getDestinationCountry());
        flight.setOriginCity(dto.getOriginCity());
        flight.setDestinationCity(dto.getDestinationCity());
        flight.setOriginAirport(dto.getOriginAirport());
        flight.setDestinationAirport(dto.getDestinationAirport());
        flight.setDepartDate(dto.getDepartDate());
        flight.setArrivalDate(dto.getArrivalDate());
        flight.setEconomyFare(dto.getEconomyFare());
        flight.setBusinessFare(dto.getBusinessFare());
        flight.setFirstClassFare(dto.getFirstClassFare());
        flight.setCompany(dto.getCompany());
        flight.setFlightType(dto.getFlightType());
        flight.setTimeTaken(dto.getTimeTaken());
        flight.setSeatsAvailable(dto.getSeatsAvailable());
        
        return flight;
    }

    public FlightDTO toDTO(Flight flight) {
        if (flight == null) {
            return null;
        }
        
        FlightDTO dto = new FlightDTO();
        dto.setFlightDetailsId(flight.getFlightDetailsId());
        dto.setFromCountry(flight.getFromCountry());
        dto.setDestinationCountry(flight.getDestinationCountry());
        dto.setOriginCity(flight.getOriginCity());
        dto.setDestinationCity(flight.getDestinationCity());
        dto.setOriginAirport(flight.getOriginAirport());
        dto.setDestinationAirport(flight.getDestinationAirport());
        dto.setDepartDate(flight.getDepartDate());
        dto.setArrivalDate(flight.getArrivalDate());
        dto.setCompany(flight.getCompany());
        dto.setFlightType(flight.getFlightType());
        dto.setTimeTaken(flight.getTimeTaken());
        dto.setSeatsAvailable(flight.getSeatsAvailable());
        
        Map<String, Double> fares = new HashMap<>();
        fares.put("economy", flight.getEconomyFare());
        fares.put("business", flight.getBusinessFare());
        fares.put("firstClass", flight.getFirstClassFare());
        dto.setFares(fares);
        
        return dto;
    }

    public Flight toCreateEntity(FlightCreateDTO dto) {
        return toEntity(dto);
    }

    public void toUpdateEntity(Flight flight, FlightUpdateDTO dto) {
        if (dto == null || flight == null) {
            return;
        }
        
        if (dto.getDepartDate() != null) {
            flight.setDepartDate(dto.getDepartDate());
        }
        if (dto.getArrivalDate() != null) {
            flight.setArrivalDate(dto.getArrivalDate());
        }
        if (dto.getEconomyFare() != null) {
            flight.setEconomyFare(dto.getEconomyFare());
        }
        if (dto.getBusinessFare() != null) {
            flight.setBusinessFare(dto.getBusinessFare());
        }
        if (dto.getFirstClassFare() != null) {
            flight.setFirstClassFare(dto.getFirstClassFare());
        }
        if (dto.getSeatsAvailable() != null) {
            flight.setSeatsAvailable(dto.getSeatsAvailable());
        }
        if (dto.getTimeTaken() != null) {
            flight.setTimeTaken(dto.getTimeTaken());
        }
    }
}