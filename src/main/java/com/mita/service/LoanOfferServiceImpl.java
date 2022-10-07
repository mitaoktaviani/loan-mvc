package com.mita.service;

import com.mita.dto.loan.UpsertLoanDTO;
import com.mita.entity.Category;
import com.mita.entity.LoanOffer;
import com.mita.repository.CategoryRepository;
import com.mita.repository.LoanOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanOfferServiceImpl implements LoanOfferService{

    private final int rowsInPage = 5;

    @Autowired
    private LoanOfferRepository loanOfferRepository;

    @Autowired
    private CategoryRepository categoryRepository;


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

    @Override
    public UpsertLoanDTO getUpdateLoan(Integer id) {
        Optional<LoanOffer> theLoan = loanOfferRepository.findById(id);
        LoanOffer loanOffer = null;
        if(theLoan.isPresent()){
            loanOffer = theLoan.get();
        }

        UpsertLoanDTO dto = new UpsertLoanDTO(
                loanOffer.getLoanId(),
                loanOffer.getCategoryID().getId(),
                loanOffer.getLoanName(),
                loanOffer.getLoanAmount(),
                loanOffer.getInterestRate(),
                loanOffer.getLoanTerm(),
                loanOffer.getRepayment(),
                loanOffer.getTotalPayment()
        );

        return dto;
    }

    @Override
    public Integer updateLoan(UpsertLoanDTO dto) {

        Optional<Category> theCategory = categoryRepository.findById(dto.getCategoryId());
        Category category = null;
        if(theCategory.isPresent()){
            category = theCategory.get();
        }
        LoanOffer loanOffer = new LoanOffer();
        loanOffer.setLoanId(dto.getLoanId());
        loanOffer.setCategoryID(category);
        loanOffer.setLoanName(dto.getLoanName());
        loanOffer.setLoanTerm(dto.getLoanTerm());
        loanOffer.setInterestRate(dto.getInterestRate());
        loanOffer.setRepayment(dto.getRepayment());
        loanOffer.setTotalPayment(dto.getTotalPayment());
        loanOffer.setLoanAmount(dto.getLoanAmount());

        loanOfferRepository.save(loanOffer);

        return loanOffer.getLoanId();
    }
}
