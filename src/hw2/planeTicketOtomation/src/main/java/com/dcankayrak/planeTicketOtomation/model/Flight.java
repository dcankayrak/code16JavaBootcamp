package com.dcankayrak.planeTicketOtomation.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {
    private String flightNumber;
    private String from;
    private String to;
    private String planeName;
    private String status;
    private Company company;
    private BigDecimal price;
    private List<Chair> chairs;

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", plane=" + planeName +
                ", status='" + status + '\'' +
                ", company=" + company +
                ", price=" + price +
                '}';
    }
}
