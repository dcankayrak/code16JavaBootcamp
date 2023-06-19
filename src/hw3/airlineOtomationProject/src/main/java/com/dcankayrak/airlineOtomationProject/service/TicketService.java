package com.dcankayrak.airlineOtomationProject.service;

import com.dcankayrak.airlineOtomationProject.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final FlightRepository flightRepository;


}
