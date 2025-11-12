package com.crossairlines.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private int airportId;
    
    @Column(name = "origin_city")
    private String originCity;
    
    @Column(name = "dest_city")
    private String destCity;
    
    @Column(name = "origin_airport")
    private String originAirport;
    
    @Column(name = "destination_airport")
    private String destinationAirport;
    
    @Column(name = "distance")
    private double distance;
    
    @Column(name = "time_taken")
    private double timeTaken;

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getOriginCity() {
        if (originCity != null) {
            originCity = originCity.replace("�", " ");
            originCity = originCity.replace("\"", "");
        }
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        if (destCity != null) {
            destCity = destCity.replace("�", " ");
            destCity = destCity.replace("\"", "");
        }
        this.destCity = destCity;
    }

    public String getOriginAirport() {
        if (originAirport != null) {
            originAirport = originAirport.replace("\"", "");
        }
        return originAirport;
    }

    public void setOriginAirport(String origin) {
        if (origin != null) {
            origin = origin.replace("\"", "");
        }
        this.originAirport = origin;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destination) {
        if (destination != null) {
            destination = destination.replace("\"", "");
        }
        this.destinationAirport = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return "\nAirport [airportId=" + airportId + ", originCity=" + originCity + ", destCity=" + destCity
                + ", originAirport=" + originAirport + ", destinationAirport=" + destinationAirport + ", distance="
                + distance + ", timeTaken=" + timeTaken + "]\n";
    }
}