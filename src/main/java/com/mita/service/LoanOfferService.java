package com.mita.service;

import com.mita.dto.loan.UpsertLoanDTO;
import com.mita.entity.LoanOffer;

import java.util.List;

public interface LoanOfferService {

    List<LoanOffer> getAll(String loanName, Integer page);

    long getTotalPages(String loanName);

    UpsertLoanDTO getUpdateLoan(Integer id);

    Integer updateLoan(UpsertLoanDTO dto);
}
