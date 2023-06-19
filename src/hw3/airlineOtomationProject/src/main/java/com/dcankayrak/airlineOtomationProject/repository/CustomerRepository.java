package com.dcankayrak.airlineOtomationProject.repository;

import com.dcankayrak.airlineOtomationProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
