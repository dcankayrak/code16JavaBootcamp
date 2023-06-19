package com.dcankayrak.airlineOtomationProject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Flight> flights;
    private BigDecimal economyClassPrice;
    private BigDecimal businessClassPrice;
    }
