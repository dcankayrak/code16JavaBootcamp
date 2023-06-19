package com.dcankayrak.airlineOtomationProject.controller;

import com.dcankayrak.airlineOtomationProject.model.Ticket;
import com.dcankayrak.airlineOtomationProject.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public List<Ticket> getAllTickets(){
        return null;
    }
}
