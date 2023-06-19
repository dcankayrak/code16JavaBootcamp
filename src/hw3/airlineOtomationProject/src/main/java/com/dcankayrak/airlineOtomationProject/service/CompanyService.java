package com.dcankayrak.airlineOtomationProject.service;

import com.dcankayrak.airlineOtomationProject.model.Company;
import com.dcankayrak.airlineOtomationProject.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }
}
