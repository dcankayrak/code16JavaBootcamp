package com.dcankayrak.airlineOtomationProject.controller;

import com.dcankayrak.airlineOtomationProject.requestDto.SaveFlightDto;
import com.dcankayrak.airlineOtomationProject.responseDto.FlightListItemDto;
import com.dcankayrak.airlineOtomationProject.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public List<FlightListItemDto> getAllFlights(){
        return this.flightService.getAllFlights();
    }

    @GetMapping("/{flightNumber}")
    public FlightListItemDto getFlightWithFlightNumber(@PathVariable String flightNumber){
        return this.flightService.getFlightWithFlightNumber(flightNumber);
    }

    @PostMapping
    public FlightListItemDto saveFlight(@RequestBody SaveFlightDto request){
        return this.flightService.saveFlight(request);
    }

    @PostMapping("/{flightNumber}/book/{userId}")
    public boolean bookFlight(@PathVariable String flightNumber, @PathVariable Long userId){
        return this.flightService.bookFlight(flightNumber,userId);
    }

    @DeleteMapping("/{flightNumber}")
    public void deleteFlight(@PathVariable String flightNumber){
        this.flightService.deleteFlight(flightNumber);
    }
}
