package com.dcankayrak.airlineOtomationProject.controller;

import com.dcankayrak.airlineOtomationProject.model.Customer;
import com.dcankayrak.airlineOtomationProject.requestDto.SaveCustomerDto;
import com.dcankayrak.airlineOtomationProject.responseDto.CustomerListItemDto;
import com.dcankayrak.airlineOtomationProject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerListItemDto> getAll(){
        return this.customerService.getAll();
    }

    @PostMapping
    public boolean saveCustomer(@RequestBody SaveCustomerDto request){
        return this.customerService.saveCustomer(request);
    }
}
