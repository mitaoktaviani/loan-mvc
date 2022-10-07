package com.mita.controller;

import com.mita.dto.creditor.CreditorDTO;
import com.mita.dto.creditor.InsertCreditorDTO;
import com.mita.service.CreditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/creditor")
public class SuperAdminController {

    @Autowired
    private CreditorService creditorService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1")Integer page,
                        @RequestParam(defaultValue = "")String fullName,
                        Model model){

        List<CreditorDTO> grid = creditorService.getAll(page, fullName);

        long totalPages = creditorService.getTotalPages(fullName);

        model.addAttribute("breadCrumbs","Creditor Index");
        model.addAttribute("fullName", fullName);
        model.addAttribute("currentPage", page);
        model.addAttribute("grid", grid);
        model.addAttribute("totalPages", totalPages);
        return "creditor/creditor-index";
    }

    @GetMapping("/insertForm")
    public String insertForm(Model model){
        InsertCreditorDTO dto = new InsertCreditorDTO();

        model.addAttribute("creditor",dto);
        model.addAttribute("type","insert");
        model.addAttribute("breadCrumbs","Add Creditor");

        return "creditor/creditor-form";
    }

    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute("creditor")InsertCreditorDTO dto,
                         BindingResult bindingResult,
                         Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("type", "insert");
            model.addAttribute("breadCrumbs","Add Creditor");

            return "creditor/creditor-form";
        } else {
            creditorService.insertCreditor(dto);

            return "redirect:/creditor/index";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(required = true)Integer id,
                         Model model){
        creditorService.deleteCreditor(id);
        return "redirect:/creditor/index";
    }
}
