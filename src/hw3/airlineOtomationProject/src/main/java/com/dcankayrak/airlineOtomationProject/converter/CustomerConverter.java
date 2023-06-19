package com.dcankayrak.airlineOtomationProject.converter;

import com.dcankayrak.airlineOtomationProject.model.Customer;
import com.dcankayrak.airlineOtomationProject.model.Flight;
import com.dcankayrak.airlineOtomationProject.responseDto.CustomerListItemDto;
import com.dcankayrak.airlineOtomationProject.responseDto.FlightListItemDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerConverter {

    private final ModelMapper modelMapper;

    public List<CustomerListItemDto> convertCustomerToCustomerListItemDto(List<Customer> customers){
        List<CustomerListItemDto> list = new ArrayList<>();
        for (Customer c:customers) {
            list.add(convertCustomerToCustomerListItemDto(c));
        }
        return list;
    }

    public CustomerListItemDto convertCustomerToCustomerListItemDto(Customer customer){
        return modelMapper.map(customer,CustomerListItemDto.class);
    }
}
