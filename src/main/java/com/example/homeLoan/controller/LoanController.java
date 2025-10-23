package com.example.homeLoan.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.homeLoan.entity.LoanApplication;
import com.example.homeLoan.entity.EMI;
import com.example.homeLoan.service.LoanService;

import java.util.List;


@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public LoanApplication applyLoan(@RequestBody LoanApplication loan) {
        return loanService.applyLoan(loan);
    }

    @PostMapping("/{id}/approve")
    public LoanApplication approveLoan(@PathVariable Long id) {
        return loanService.approveLoan(id);
    }

    @PostMapping("/{id}/reject")
    public LoanApplication rejectLoan(@PathVariable Long id) {
        return loanService.rejectLoan(id);
    }

    @GetMapping("/{id}/emis")
    public List<EMI> getEMIs(@PathVariable Long id) {
        return loanService.getEMIsForLoan(id);
    }
}
