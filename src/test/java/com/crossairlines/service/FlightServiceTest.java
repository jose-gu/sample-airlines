package com.crossairlines.service;

import com.crossairlines.dto.FlightCreateDTO;
import com.crossairlines.dto.FlightDTO;
import com.crossairlines.dto.FlightUpdateDTO;
import com.crossairlines.exception.FlightNotFoundException;
import com.crossairlines.exception.FlightValidationException;
import com.crossairlines.mapper.FlightMapper;
import com.crossairlines.model.Flight;
import com.crossairlines.repository.AirportRepository;
import com.crossairlines.repository.FlightRepository;
import com.crossairlines.service.impl.FlightServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private AirportRepository airportRepository;

    @Mock
    private FlightMapper flightMapper;

    @InjectMocks
    private FlightServiceImpl flightService;

    private FlightCreateDTO createDTO;
    private Flight flight;
    private FlightDTO flightDTO;

    @BeforeEach
    void setUp() {
        createDTO = new FlightCreateDTO();
        createDTO.setFromCountry("India");
        createDTO.setDestinationCountry("USA");
        createDTO.setOriginCity("Mumbai");
        createDTO.setDestinationCity("New York");
        createDTO.setOriginAirport("BOM");
        createDTO.setDestinationAirport("JFK");
        createDTO.setDepartDate(LocalDateTime.now().plusDays(1));
        createDTO.setArrivalDate(LocalDateTime.now().plusDays(2));
        createDTO.setEconomyFare(500.0);
        createDTO.setBusinessFare(1500.0);
        createDTO.setFirstClassFare(3000.0);
        createDTO.setCompany("Air India");
        createDTO.setFlightType("Non Stop");
        createDTO.setSeatsAvailable(100);

        flight = new Flight();
        flight.setFlightDetailsId(1L);
        flight.setFromCountry("India");
        flight.setDestinationCountry("USA");
        flight.setOriginCity("Mumbai");
        flight.setDestinationCity("New York");
        flight.setSeatsAvailable(100);

        flightDTO = new FlightDTO();
        flightDTO.setFlightDetailsId(1L);
        flightDTO.setFromCountry("India");
        flightDTO.setDestinationCountry("USA");
        flightDTO.setOriginCity("Mumbai");
        flightDTO.setDestinationCity("New York");
    }

    @Test
    void testCreateFlight() {
        when(flightMapper.toCreateEntity(createDTO)).thenReturn(flight);
        when(flightRepository.save(flight)).thenReturn(flight);
        when(flightMapper.toDTO(flight)).thenReturn(flightDTO);

        FlightDTO result = flightService.createFlight(createDTO);

        assertNotNull(result);
        assertEquals(1L, result.getFlightDetailsId());
        assertEquals("India", result.getFromCountry());
        verify(flightRepository).save(flight);
    }

    @Test
    void testUpdateFlight() {
        FlightUpdateDTO updateDTO = new FlightUpdateDTO();
        updateDTO.setEconomyFare(550.0);
        updateDTO.setSeatsAvailable(80);

        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));
        when(flightRepository.save(flight)).thenReturn(flight);
        when(flightMapper.toDTO(flight)).thenReturn(flightDTO);

        FlightDTO result = flightService.updateFlight(1L, updateDTO);

        assertNotNull(result);
        verify(flightMapper).toUpdateEntity(flight, updateDTO);
        verify(flightRepository).save(flight);
    }

    @Test
    void testUpdateFlightNotFound() {
        FlightUpdateDTO updateDTO = new FlightUpdateDTO();
        when(flightRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(FlightNotFoundException.class, () -> {
            flightService.updateFlight(1L, updateDTO);
        });
    }

    @Test
    void testRemoveFlight() {
        when(flightRepository.existsById(1L)).thenReturn(true);

        flightService.removeFlight(1L);

        verify(flightRepository).deleteById(1L);
    }

    @Test
    void testRemoveFlightNotFound() {
        when(flightRepository.existsById(1L)).thenReturn(false);

        assertThrows(FlightNotFoundException.class, () -> {
            flightService.removeFlight(1L);
        });
    }

    @Test
    void testValidationSameCities() {
        createDTO.setOriginCity("Mumbai");
        createDTO.setDestinationCity("Mumbai");

        assertThrows(FlightValidationException.class, () -> {
            flightService.validateFlightData(createDTO);
        });
    }

    @Test
    void testValidationEconomyFareHigherThanBusiness() {
        createDTO.setEconomyFare(2000.0);
        createDTO.setBusinessFare(1500.0);

        assertThrows(FlightValidationException.class, () -> {
            flightService.validateFlightData(createDTO);
        });
    }
}