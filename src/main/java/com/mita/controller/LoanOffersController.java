package com.mita.controller;

import com.mita.entity.LoanOffer;
import com.mita.service.LoanOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class LoanOffersController {

    @Autowired
    private LoanOfferService loanOfferService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1")Integer page,
                        @RequestParam(defaultValue = "")String loanName, Model model){

        List<LoanOffer> loanOffers = loanOfferService.getAll(loanName,page);

        long totalPages = loanOfferService.getTotalPages(loanName);

        model.addAttribute("currentPage",page);
        model.addAttribute("grid",loanOffers);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("loanName", loanName);
        model.addAttribute("breadCrumbs","Loan Product");
        return "loan/loan-index";
    }
}
