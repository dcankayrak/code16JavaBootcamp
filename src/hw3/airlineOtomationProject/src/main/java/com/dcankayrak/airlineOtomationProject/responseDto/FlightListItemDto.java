package com.dcankayrak.airlineOtomationProject.responseDto;

import com.dcankayrak.airlineOtomationProject.model.Customer;
import lombok.Data;

import java.util.List;

@Data
public class FlightListItemDto {
    private Long id;
    private String flightNumber;
    private String departure;
    private String landing;
    private boolean isAbroadFlight;

    private List<Customer> customers;
}
