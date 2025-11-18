package com.crossairlines.dto.response;

import java.util.List;
import com.crossairlines.dto.FlightDetailsDTO;

public class FlightSearchResponse {
    
    private List<FlightDetailsDTO> matchingFlights;
    private List<FlightDetailsDTO> alternativeFlights;
    
    public List<FlightDetailsDTO> getMatchingFlights() {
        return matchingFlights;
    }
    
    public void setMatchingFlights(List<FlightDetailsDTO> matchingFlights) {
        this.matchingFlights = matchingFlights;
    }
    
    public List<FlightDetailsDTO> getAlternativeFlights() {
        return alternativeFlights;
    }
    
    public void setAlternativeFlights(List<FlightDetailsDTO> alternativeFlights) {
        this.alternativeFlights = alternativeFlights;
    }
}