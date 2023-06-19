package com.dcankayrak.airlineOtomationProject.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Chair {
    private String name;
    private Customer customer;
    private boolean isBussiness;
    private BigDecimal price;
    
    public Chair(String name) {
        this.name = name;
    }

    public Chair(String name, boolean isBussiness) {
        this.name = name;
        this.isBussiness = isBussiness;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                ", isBussiness=" + isBussiness +
                '}';
    }
}
