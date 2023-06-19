package com.dcankayrak.airlineOtomationProject.converter;

import com.dcankayrak.airlineOtomationProject.model.Flight;
import com.dcankayrak.airlineOtomationProject.responseDto.FlightListItemDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FlightConverter {

    private final ModelMapper modelMapper;

    public List<FlightListItemDto> convertFlightToFlightListItemDto(List<Flight> flights){
        List<FlightListItemDto> list = new ArrayList<>();
        for (Flight f:flights) {
            list.add(convertFlightToFlightListItemDto(f));
        }
        return list;
    }

    public FlightListItemDto convertFlightToFlightListItemDto(Flight flight){
        return modelMapper.map(flight,FlightListItemDto.class);
    }

}
