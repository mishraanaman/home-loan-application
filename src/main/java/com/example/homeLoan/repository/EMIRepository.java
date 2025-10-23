package com.example.homeLoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.homeLoan.entity.EMI;
import java.util.List;

public interface EMIRepository extends JpaRepository<EMI, Long> {
    List<EMI> findByLoanApplicationId(Long loanApplicationId);
}