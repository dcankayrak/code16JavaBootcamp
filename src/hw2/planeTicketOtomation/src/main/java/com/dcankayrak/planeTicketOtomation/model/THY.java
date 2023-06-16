package com.dcankayrak.planeTicketOtomation.model;

import com.dcankayrak.planeTicketOtomation.model.abstracts.ServeService;

import java.util.List;

public class THY extends Company implements ServeService {


    @Override
    public void serve() {
        System.out.println("Sandviç Dağıtımı Başlatıldı!");
    }
}
