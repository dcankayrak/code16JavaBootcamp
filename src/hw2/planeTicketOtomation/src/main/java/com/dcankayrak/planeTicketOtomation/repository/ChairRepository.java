package com.dcankayrak.planeTicketOtomation.repository;

import com.dcankayrak.planeTicketOtomation.model.Chair;

import java.util.ArrayList;
import java.util.List;

public class ChairRepository {
    private List<Chair> chairs = new ArrayList<>();

    public ChairRepository(){
        // Economy Class
        this.chairs.add(new Chair("A1"));
        this.chairs.add(new Chair("A2"));
        this.chairs.add(new Chair("A3"));
        this.chairs.add(new Chair("A4"));
        this.chairs.add(new Chair("A5"));
        this.chairs.add(new Chair("A6"));
        this.chairs.add(new Chair("A7"));
        this.chairs.add(new Chair("A8"));

        // Business Class
        this.chairs.add(new Chair("B1"));
        this.chairs.add(new Chair("B2"));
        this.chairs.add(new Chair("B3"));
        this.chairs.add(new Chair("B4"));
    }

    public List<Chair> getChairs(){
        return chairs;
    }
}
