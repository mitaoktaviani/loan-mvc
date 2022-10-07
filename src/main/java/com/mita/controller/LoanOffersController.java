package com.mita.controller;

import com.mita.dto.loan.UpsertLoanDTO;
import com.mita.entity.LoanOffer;
import com.mita.service.CategoryService;
import com.mita.service.LoanOfferService;
import com.mita.utility.DropDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class LoanOffersController {

    @Autowired
    private LoanOfferService loanOfferService;

    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("/upsertForm")
    public String upsertForm(@RequestParam(required = false)Integer id,
                             Model model){

        if(id == null){
            UpsertLoanDTO dto = loanOfferService.getUpdateLoan(id);

            model.addAttribute("loan",dto);
            model.addAttribute("type","update");
            model.addAttribute("breadCrumbs","Loan Index/ Update Loan");
        }else{
            UpsertLoanDTO dto = new UpsertLoanDTO();

            model.addAttribute("loan",dto);
            model.addAttribute("type","insert");
            model.addAttribute("breadCrumbs","Loan Index / Insert Loan");
        }
        return "loan/loan-form";
    }

    @PostMapping("/update")
    public String insert(@Valid @ModelAttribute("loan")UpsertLoanDTO dto,
                         BindingResult bindingResult, Model model){

        List<DropDown> category = categoryService.categoryDropDown();
        model.addAttribute("categoryDropDown",category);

        if(bindingResult.hasErrors()){
            model.addAttribute("loan",dto);
            model.addAttribute("type","update");

            return "loan/loan-form";
        }
        else{
            loanOfferService.updateLoan(dto);
            return "redirect:/loan/index";
        }
    }
}
