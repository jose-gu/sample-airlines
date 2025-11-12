package com.crossairlines.controller;

import com.crossairlines.dto.FlightCreateDTO;
import com.crossairlines.dto.FlightDTO;
import com.crossairlines.dto.FlightUpdateDTO;
import com.crossairlines.service.FlightService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddFlight() throws Exception {
        FlightCreateDTO createDTO = new FlightCreateDTO();
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

        FlightDTO responseDTO = new FlightDTO();
        responseDTO.setFlightDetailsId(1L);
        responseDTO.setFromCountry("India");
        responseDTO.setDestinationCountry("USA");
        responseDTO.setOriginCity("Mumbai");
        responseDTO.setDestinationCity("New York");
        responseDTO.setCompany("Air India");
        responseDTO.setFlightType("Non Stop");

        when(flightService.createFlight(any(FlightCreateDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(post("/api/flights")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.flightDetailsId").value(1L))
                .andExpect(jsonPath("$.fromCountry").value("India"))
                .andExpect(jsonPath("$.destinationCountry").value("USA"));
    }

    @Test
    public void testUpdateFlight() throws Exception {
        FlightUpdateDTO updateDTO = new FlightUpdateDTO();
        updateDTO.setEconomyFare(550.0);
        updateDTO.setBusinessFare(1600.0);
        updateDTO.setSeatsAvailable(80);

        FlightDTO responseDTO = new FlightDTO();
        responseDTO.setFlightDetailsId(1L);
        responseDTO.setFromCountry("India");
        responseDTO.setDestinationCountry("USA");
        responseDTO.setSeatsAvailable(80);

        when(flightService.updateFlight(eq(1L), any(FlightUpdateDTO.class))).thenReturn(responseDTO);

        mockMvc.perform(put("/api/flights/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.flightDetailsId").value(1L))
                .andExpect(jsonPath("$.seatsAvailable").value(80));
    }

    @Test
    public void testDeleteFlight() throws Exception {
        mockMvc.perform(delete("/api/flights/1"))
                .andExpect(status().isNoContent());

        verify(flightService).removeFlight(1L);
    }

    @Test
    public void testGetAllFlights() throws Exception {
        FlightDTO flight1 = new FlightDTO();
        flight1.setFlightDetailsId(1L);
        flight1.setFromCountry("India");
        flight1.setDestinationCountry("USA");

        FlightDTO flight2 = new FlightDTO();
        flight2.setFlightDetailsId(2L);
        flight2.setFromCountry("UK");
        flight2.setDestinationCountry("Canada");

        when(flightService.getAllFlights()).thenReturn(Arrays.asList(flight1, flight2));

        mockMvc.perform(get("/api/flights"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].flightDetailsId").value(1L))
                .andExpect(jsonPath("$[1].flightDetailsId").value(2L));
    }
}