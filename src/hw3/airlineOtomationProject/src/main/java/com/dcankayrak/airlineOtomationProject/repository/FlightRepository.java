package com.dcankayrak.airlineOtomationProject.repository;

import com.dcankayrak.airlineOtomationProject.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,String> {
    Flight findByFlightNumber(String flightNumber);
}
