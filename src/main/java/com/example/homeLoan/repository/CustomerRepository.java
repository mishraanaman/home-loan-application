package com.example.homeLoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.homeLoan.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
