package com.example.homeLoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.homeLoan.entity.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {}