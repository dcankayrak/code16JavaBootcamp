package com.dcankayrak.airlineOtomationProject.service;

import com.dcankayrak.airlineOtomationProject.converter.CustomerConverter;
import com.dcankayrak.airlineOtomationProject.model.Customer;
import com.dcankayrak.airlineOtomationProject.repository.CustomerRepository;
import com.dcankayrak.airlineOtomationProject.requestDto.SaveCustomerDto;
import com.dcankayrak.airlineOtomationProject.responseDto.CustomerListItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public List<CustomerListItemDto> getAll() {
        List<CustomerListItemDto> list = customerConverter.convertCustomerToCustomerListItemDto(this.customerRepository.findAll());
        return list;
    }

    public boolean saveCustomer(SaveCustomerDto request){
        Customer temp = Customer
                .builder()
                .fullName(request.getFullName())
                .nationalityId(request.getNationalityId())
                .build();
        this.customerRepository.save(temp);
        return true;
    }
}
