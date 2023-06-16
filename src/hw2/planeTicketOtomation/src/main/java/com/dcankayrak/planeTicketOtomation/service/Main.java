package com.dcankayrak.planeTicketOtomation.service;

import com.dcankayrak.planeTicketOtomation.model.Chair;
import com.dcankayrak.planeTicketOtomation.repository.ChairRepository;
import com.dcankayrak.planeTicketOtomation.repository.FlightRepository;

public class Main {
    public static void main(String[] args) {
        ChairRepository chairRepository = new ChairRepository();
        FlightRepository flightRepository = new FlightRepository(chairRepository);
        TicketService ticketService = new TicketService(flightRepository);


        AirlineSystem system = new AirlineSystem(ticketService,flightRepository);
        system.start();
    }
}
