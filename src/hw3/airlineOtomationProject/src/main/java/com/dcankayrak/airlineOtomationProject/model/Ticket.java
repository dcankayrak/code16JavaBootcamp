package com.dcankayrak.airlineOtomationProject.model;

import com.dcankayrak.airlineOtomationProject.repository.FlightRepository;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class Ticket {
    private Long id;
    private Customer customer;
    private Flight flight;
    private Chair chair;
}
