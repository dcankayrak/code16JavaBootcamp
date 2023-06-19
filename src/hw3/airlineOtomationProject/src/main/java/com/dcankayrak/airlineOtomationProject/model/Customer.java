package com.dcankayrak.airlineOtomationProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nationality_id")
    private String nationalityId;
    @Column(name = "full_name")
    private String fullName;

    @JsonIgnore
    @ManyToMany(mappedBy = "customers")
    private List<Flight> bookedFlights;

    public Customer(String nationalityId){
        this.nationalityId = nationalityId;
    }
}
