package com.dcankayrak.planeTicketOtomation.service;

import com.dcankayrak.planeTicketOtomation.model.Flight;
import com.dcankayrak.planeTicketOtomation.repository.FlightRepository;

import java.util.Scanner;

public class AirlineSystem {
    private static final Scanner input = new Scanner(System.in);

    private final FlightRepository flightRepository;
    private final TicketService ticketService;

    public AirlineSystem(TicketService ticketService,FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
        this.ticketService = ticketService;
    }

    public void start(){
        System.out.println("------------------------------");
        System.out.println("Uygulamamıza hoşgeldiniz!");
        System.out.println("------------------------------");


        while(true){

            mainMenu();
            int selection = input.nextInt();
            switch (selection){
                // List all flights
                case 1:
                    listAllFlights();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 0:
                    System.out.println("Bizi tercih ettiğiniz için teşekkürler!");
                    return;
            }
        }
    }

    private void buyTicket(){
        System.out.println("------------------------------");
        System.out.println("Almak istediğiniz uçuşun uçuş numarası : ");
        String flightNumber = input.next();

        Flight selected = flightRepository.getWithId(flightNumber);
        if(selected != null){
            System.out.println("Almak istediğiniz uçuş için boş koltuklar şu şekildedir :");

            selected.getChairs().stream()
                    .filter(c -> c.getCustomer() == null)
                    .forEach(chair -> System.out.println(chair.getName()));

            System.out.println("------------------------------");
            System.out.println("Almak istediğiniz koltuk numarasını giriniz :");
            String chairNumber = input.next();

            System.out.println("Almak istediğiniz müşterinin kimlik numarasını giriniz :");
            String nationalityId = input.next();

            ticketService.buyTicket(flightNumber,chairNumber,nationalityId);
        }
        else{
            throw new RuntimeException("Girilen uçuş numarasına ait uçuş bulunmamaktadır.");
        }

    }
    private void mainMenu(){
        System.out.println("------------------------------");
        System.out.println("Tüm uçuşları görmek için 1'e\nBilet almak için 2'yi giriniz.");
        System.out.println("Yapmak istediğiniz işlemi giriniz");
    }
    private void listAllFlights(){
        while(true) {
            System.out.println("------------------------------");
            System.out.println("Tüm uçuşlarımız şu şekildedir : ");

            for (Flight f : this.flightRepository.getAll()) {
                System.out.println(f);
            }

            System.out.println("------------------------------");
            System.out.println("Çıkış için 0'a basınız");
            if(input.nextInt() == 0){
                break;
            }
        }
    }
}
