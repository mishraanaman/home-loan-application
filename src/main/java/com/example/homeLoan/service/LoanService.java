package com.example.homeLoan.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.time.LocalDate;

import com.example.homeLoan.entity.EMI;
import com.example.homeLoan.entity.LoanApplication;
import com.example.homeLoan.repository.EMIRepository;
import com.example.homeLoan.repository.LoanApplicationRepository;
import com.example.homeLoan.repository.CustomerRepository;

@Service
public class LoanService {

    @Autowired
    private LoanApplicationRepository loanRepo;

    @Autowired
    private EMIRepository emiRepo;

    @Autowired
    private CustomerRepository customerRepo;

    public LoanApplication applyLoan(LoanApplication loan) {
        // Save customer first if it doesn't have an ID
        if (loan.getCustomer() != null && loan.getCustomer().getId() == null) {
            loan.setCustomer(customerRepo.save(loan.getCustomer()));
        }
        
        loan.setStatus("PENDING");
        LoanApplication savedLoan = loanRepo.save(loan);
        generateEMISchedule(savedLoan);
        return savedLoan;
    }

    private void generateEMISchedule(LoanApplication loan) {
        double emiAmount = loan.getAmount() / loan.getTenureMonths();
        LocalDate startDate = LocalDate.now().plusMonths(1);
        for (int i = 0; i < loan.getTenureMonths(); i++) {
            EMI emi = new EMI();
            emi.setLoanApplication(loan);
            emi.setEmiAmount(emiAmount);
            emi.setDueDate(startDate.plusMonths(i));
            emi.setPaid(false);
            emiRepo.save(emi);
        }
    }

    public LoanApplication approveLoan(Long loanId) {
        LoanApplication loan = loanRepo.findById(loanId).orElseThrow();
        loan.setStatus("APPROVED");
        return loanRepo.save(loan);
    }

    public LoanApplication rejectLoan(Long loanId) {
        LoanApplication loan = loanRepo.findById(loanId).orElseThrow();
        loan.setStatus("REJECTED");
        return loanRepo.save(loan);
    }

    public List<EMI> getEMIsForLoan(Long loanId) {
        return emiRepo.findByLoanApplicationId(loanId);
    }
}
