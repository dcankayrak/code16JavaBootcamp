package com.dcankayrak.airlineOtomationProject.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "flightNumber")
    private String flightNumber;
    @Column(name = "departure")
    private String departure;
    @Column(name = "landing")
    private String landing;
    @Column(name = "isAbroadFlight")
    private boolean isAbroadFlight;
    @Column(name = "planeName")
    private String planeName;

    @ManyToMany
    @JoinTable(name = "booked_flights",joinColumns = @JoinColumn(name = "customer_id"),inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private List<Customer> customers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    private Company company;
}

