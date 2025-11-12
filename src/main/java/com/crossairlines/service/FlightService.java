package com.crossairlines.service;

import com.crossairlines.dto.FlightCreateRequest;
import com.crossairlines.dto.FlightDetailsDto;
import com.crossairlines.dto.FlightUpdateRequest;
import com.crossairlines.exception.FlightNotFoundException;
import com.crossairlines.exception.InvalidFlightDataException;
import com.crossairlines.mapper.FlightMapper;
import com.crossairlines.model.FlightDetails;
import com.crossairlines.repository.AirportRepository;
import com.crossairlines.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightService {
    
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final FlightMapper flightMapper;
    
    @Autowired
    public FlightService(FlightRepository flightRepository, 
                        AirportRepository airportRepository, 
                        FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.flightMapper = flightMapper;
    }
    
    public FlightDetailsDto createFlight(FlightCreateRequest request) {
        validateFlightData(request.getOriginCity(), request.getDestinationCity(), 
                          request.getDepartDate(), request.getArrivalDate());
        
        FlightDetails flight = flightMapper.toCreateEntity(request);
        FlightDetails savedFlight = flightRepository.save(flight);
        return flightMapper.toDto(savedFlight);
    }
    
    public FlightDetailsDto updateFlight(FlightUpdateRequest request) {
        FlightDetails existingFlight = flightRepository.findById(request.getFlightDetailsId())
                .orElseThrow(() -> new FlightNotFoundException(request.getFlightDetailsId()));
        
        if (request.getOriginCity().isPresent() || request.getDestinationCity().isPresent() ||
            request.getDepartDate().isPresent() || request.getArrivalDate().isPresent()) {
            String originCity = request.getOriginCity().orElse(existingFlight.getOriginCity());
            String destinationCity = request.getDestinationCity().orElse(existingFlight.getDestinationCity());
            validateFlightData(originCity, destinationCity, 
                              request.getDepartDate().orElse(existingFlight.getDepartDate()),
                              request.getArrivalDate().orElse(existingFlight.getArrivalDate()));
        }
        
        FlightDetails updatedFlight = flightMapper.toUpdateEntity(existingFlight, request);
        FlightDetails savedFlight = flightRepository.save(updatedFlight);
        return flightMapper.toDto(savedFlight);
    }
    
    public void deleteFlight(Integer flightId) {
        if (!flightRepository.existsById(flightId)) {
            throw new FlightNotFoundException(flightId);
        }
        flightRepository.deleteById(flightId);
    }
    
    @Transactional(readOnly = true)
    public FlightDetailsDto getFlightById(Integer flightId) {
        FlightDetails flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException(flightId));
        return flightMapper.toDto(flight);
    }
    
    @Transactional(readOnly = true)
    public List<FlightDetailsDto> getAllFlights() {
        List<FlightDetails> flights = flightRepository.findAll();
        return flights.stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public FlightDetailsDto updateAvailability(Integer flightId, Integer seatsAvailable) {
        FlightDetails flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException(flightId));
        
        if (seatsAvailable < 0) {
            throw new InvalidFlightDataException("Seats available cannot be negative");
        }
        
        flight.setSeatsAvailable(seatsAvailable);
        FlightDetails savedFlight = flightRepository.save(flight);
        return flightMapper.toDto(savedFlight);
    }
    
    private void validateFlightData(String originCity, String destinationCity, 
                                   java.util.Date departDate, java.util.Date arrivalDate) {
        if (originCity.equals(destinationCity)) {
            throw new InvalidFlightDataException("Origin and destination cities cannot be the same");
        }
        
        if (departDate.after(arrivalDate)) {
            throw new InvalidFlightDataException("Departure date cannot be after arrival date");
        }
        
        checkRouteExists(originCity, destinationCity);
    }
    
    private void checkRouteExists(String originCity, String destinationCity) {
        boolean routeExists = airportRepository.existsByOriginCityAndDestCity(originCity, destinationCity);
        if (!routeExists) {
            throw new InvalidFlightDataException("Route from " + originCity + " to " + destinationCity + " does not exist");
        }
    }
}