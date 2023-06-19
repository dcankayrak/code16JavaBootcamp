package com.dcankayrak.planeTicketOtomation.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    String name;
    List<Flight> flights;
    BigDecimal economyClassPrice;
    BigDecimal businessClassPrice;

    }
