package com.dcankayrak.planeTicketOtomation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chair {
    private String name;
    private Customer customer;

    public Chair(String name) {
        this.name = name;
    }
}
