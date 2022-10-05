package com.mita.service;

import com.mita.entity.LoanOffer;
import com.mita.repository.LoanOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanOfferServiceImpl implements LoanOfferService{

    private final int rowsInPage = 5;

    @Autowired
    private LoanOfferRepository loanOfferRepository;


    @Override
    public List<LoanOffer> getAll(String loanName, Integer page) {
        Pageable pagination = PageRequest.of(page-1, rowsInPage, Sort.by("loanId"));

        List<LoanOffer> loanOffers = loanOfferRepository.getAll(loanName,pagination);
        return loanOffers;
    }

    @Override
    public long getTotalPages(String loanName) {
        double totalData = (double)(loanOfferRepository.countLoan(loanName));
        long totalPage = (long)(Math.ceil(totalData / rowsInPage));
        return totalPage;
    }
}
