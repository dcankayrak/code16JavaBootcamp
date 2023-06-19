package com.dcankayrak.airlineOtomationProject.controller;

import com.dcankayrak.airlineOtomationProject.model.Company;
import com.dcankayrak.airlineOtomationProject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public List<Company> getAllCompanies(){
        return this.companyService.getAllCompanies();
    }
}
