package com.dcankayrak.planeTicketOtomation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private Long id;
    private String nationalityId;
    private String fullName;

    public Customer(String nationalityId){
        this.nationalityId = nationalityId;
    }
}
