package com.crossairlines.service.impl;

import com.crossairlines.dto.FlightCreateDTO;
import com.crossairlines.dto.FlightDTO;
import com.crossairlines.dto.FlightUpdateDTO;
import com.crossairlines.exception.FlightNotFoundException;
import com.crossairlines.exception.FlightValidationException;
import com.crossairlines.mapper.FlightMapper;
import com.crossairlines.model.Flight;
import com.crossairlines.repository.AirportRepository;
import com.crossairlines.repository.FlightRepository;
import com.crossairlines.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private FlightMapper flightMapper;

    @Override
    public FlightDTO createFlight(FlightCreateDTO flightCreateDTO) {
        validateFlightData(flightCreateDTO);
        validateFlightSchedule(flightCreateDTO.getDepartDate(), flightCreateDTO.getArrivalDate());
        validateFlightCapacity(flightCreateDTO.getSeatsAvailable());
        
        Flight flight = flightMapper.toCreateEntity(flightCreateDTO);
        Flight savedFlight = flightRepository.save(flight);
        return flightMapper.toDTO(savedFlight);
    }

    @Override
    public FlightDTO updateFlight(Long id, FlightUpdateDTO flightUpdateDTO) {
        Flight existingFlight = flightRepository.findById(id)
            .orElseThrow(() -> new FlightNotFoundException(id));
        
        if (flightUpdateDTO.getDepartDate() != null && flightUpdateDTO.getArrivalDate() != null) {
            validateFlightSchedule(flightUpdateDTO.getDepartDate(), flightUpdateDTO.getArrivalDate());
        }
        
        if (flightUpdateDTO.getSeatsAvailable() != null) {
            validateFlightCapacity(flightUpdateDTO.getSeatsAvailable());
        }
        
        flightMapper.toUpdateEntity(existingFlight, flightUpdateDTO);
        Flight updatedFlight = flightRepository.save(existingFlight);
        return flightMapper.toDTO(updatedFlight);
    }

    @Override
    public void removeFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new FlightNotFoundException(id);
        }
        flightRepository.deleteById(id);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream()
            .map(flightMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
            .orElseThrow(() -> new FlightNotFoundException(id));
        return flightMapper.toDTO(flight);
    }

    @Override
    public void validateFlightData(FlightCreateDTO flightCreateDTO) {
        if (flightCreateDTO == null) {
            throw new FlightValidationException("Flight data cannot be null");
        }
        
        if (flightCreateDTO.getOriginCity() != null && 
            flightCreateDTO.getDestinationCity() != null && 
            flightCreateDTO.getOriginCity().equals(flightCreateDTO.getDestinationCity())) {
            throw new FlightValidationException("Origin and destination cities cannot be the same");
        }
        
        if (flightCreateDTO.getEconomyFare() != null && 
            flightCreateDTO.getBusinessFare() != null && 
            flightCreateDTO.getEconomyFare() > flightCreateDTO.getBusinessFare()) {
            throw new FlightValidationException("Economy fare cannot be higher than business fare");
        }
        
        if (flightCreateDTO.getBusinessFare() != null && 
            flightCreateDTO.getFirstClassFare() != null && 
            flightCreateDTO.getBusinessFare() > flightCreateDTO.getFirstClassFare()) {
            throw new FlightValidationException("Business fare cannot be higher than first class fare");
        }
    }

    private void validateFlightSchedule(LocalDateTime departDate, LocalDateTime arrivalDate) {
        if (departDate != null && arrivalDate != null) {
            if (departDate.isAfter(arrivalDate) || departDate.isEqual(arrivalDate)) {
                throw new FlightValidationException("Departure date must be before arrival date");
            }
        }
    }

    private void validateFlightCapacity(Integer seatsAvailable) {
        if (seatsAvailable != null && seatsAvailable < 0) {
            throw new FlightValidationException("Seats available cannot be negative");
        }
    }
}