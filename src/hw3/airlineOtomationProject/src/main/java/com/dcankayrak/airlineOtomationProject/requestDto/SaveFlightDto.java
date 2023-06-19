package com.dcankayrak.airlineOtomationProject.requestDto;

import lombok.Data;

@Data
public class SaveFlightDto {
    private String flightNumber;
    private String from;
    private String to;
    private String planeName;
    private Long companyId;
    private boolean isAbroadFlight;
}
