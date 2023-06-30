package com.dcankayrak.airlineOtomationProject.repository;

import com.dcankayrak.airlineOtomationProject.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight,String> {
    Optional<Flight> findByFlightNumber(String flightNumber);
}
