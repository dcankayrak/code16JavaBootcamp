package com.dcankayrak.planeTicketOtomation.repository;

import com.dcankayrak.planeTicketOtomation.model.Chair;
import com.dcankayrak.planeTicketOtomation.model.Flight;
import com.dcankayrak.planeTicketOtomation.model.THY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class FlightRepository {
    private List<Flight> flights = new ArrayList<>();

    private final ChairRepository chairRepository;

    public FlightRepository(ChairRepository chairRepository) {
        this.chairRepository = chairRepository;
        this.flights.add(Flight
                .builder()
                .flightNumber("A123")
                .planeName("BOEING_A320")
                .company(new THY())
                .price(new BigDecimal(750))
                .chairs(chairRepository.getChairs())
                .to("Amsterdam")
                .from("Ankara")
                .build());
    }

    public List<Flight> getAll() {
        return flights;
    }

    public Flight getWithId(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equals(flightNumber))
                .findFirst()
                .orElseThrow();
    }
}
