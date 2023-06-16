package com.dcankayrak.planeTicketOtomation.service;

import com.dcankayrak.planeTicketOtomation.model.Chair;
import com.dcankayrak.planeTicketOtomation.model.Customer;
import com.dcankayrak.planeTicketOtomation.model.Flight;
import com.dcankayrak.planeTicketOtomation.repository.FlightRepository;

public class TicketService {

    private final FlightRepository flightRepository;

    public TicketService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public boolean buyTicket(String flightNumber, String chairNum, String customerNationalityId){
        // get flight
        Flight tempFlight = this.flightRepository.getWithId(flightNumber);
        Chair tempChair = tempFlight.getChairs()
                .stream()
                .filter(c -> c.getName().equals(chairNum))
                .findFirst().orElse(null);

        if(tempChair != null){
            tempChair.setCustomer(new Customer(customerNationalityId));
            System.out.println("Satın alım başarılı!");
        }else{
            throw new RuntimeException("Koltuk bulunamadı!");
        }
        return false;
    }
}
