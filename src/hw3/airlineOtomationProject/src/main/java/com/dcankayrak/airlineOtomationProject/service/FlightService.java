package com.dcankayrak.airlineOtomationProject.service;

import com.dcankayrak.airlineOtomationProject.converter.FlightConverter;
import com.dcankayrak.airlineOtomationProject.exception.CustomerNotFoundException;
import com.dcankayrak.airlineOtomationProject.exception.FlightNotFoundException;
import com.dcankayrak.airlineOtomationProject.model.Customer;
import com.dcankayrak.airlineOtomationProject.model.Flight;
import com.dcankayrak.airlineOtomationProject.repository.CustomerRepository;
import com.dcankayrak.airlineOtomationProject.repository.FlightRepository;
import com.dcankayrak.airlineOtomationProject.requestDto.SaveFlightDto;
import com.dcankayrak.airlineOtomationProject.responseDto.FlightListItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightConverter flightConverter;
    private final CustomerRepository customerRepository;
    public List<FlightListItemDto> getAllFlights() {
        List<FlightListItemDto> flights = flightConverter.convertFlightToFlightListItemDto(this.flightRepository.findAll());
        return flights;
    }

    public FlightListItemDto getFlightWithFlightNumber(String flightNumber) {
        FlightListItemDto flight = flightConverter.convertFlightToFlightListItemDto(this.flightRepository.findByFlightNumber(flightNumber).get());
        return flight;
    }

    public boolean bookFlight(String flightNumber,Long userId){
        Flight flight = this.flightRepository.findByFlightNumber(flightNumber).orElseThrow(() -> {throw new FlightNotFoundException("Aradığınız uçuş numarasına sahip uçuş bulunammadı!");});
        Customer customer = customerRepository.findById(userId).orElseThrow(() -> {throw new CustomerNotFoundException("Kullanıcı Bulunmadı!");});

        if(flight != null){
            flight.getCustomers().add(customer);
            this.flightRepository.save(flight);
            return true;
        }
        return false;
    }
    public FlightListItemDto saveFlight(SaveFlightDto request) {
        Flight flight = Flight
                .builder()
                .flightNumber(request.getFlightNumber())
                .departure(request.getFrom())
                .landing(request.getTo())
                .isAbroadFlight(request.isAbroadFlight())
                .build();
        this.flightRepository.save(flight);

        return this.flightConverter.convertFlightToFlightListItemDto(flight);
    }

    public void deleteFlight(String flightNumber) {
        Flight f = this.flightRepository.findByFlightNumber(flightNumber).orElseThrow(() -> {throw new FlightNotFoundException("Aradığınız uçuş numarasına sahip uçuş bulunammadı!");});
        this.flightRepository.delete(f);
    }
}
