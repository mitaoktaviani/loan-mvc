package com.mita.service;

import com.mita.dto.creditor.CreditorDTO;
import com.mita.dto.creditor.InsertCreditorDTO;
import com.mita.entity.Account;
import com.mita.entity.Creditor;
import com.mita.repository.AccountRepository;
import com.mita.repository.CreditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditorServiceImpl implements CreditorService{

    private final int rowsInPage = 5;

    @Autowired
    private CreditorRepository creditorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<CreditorDTO> getAll(Integer page, String fullName) {
        Pageable pagination = PageRequest.of(page-1, rowsInPage, Sort.by("id"));

        List<CreditorDTO> creditors = creditorRepository.getAll(fullName, pagination);
        return creditors;
    }

    @Override
    public long getTotalPages(String fullName) {
        double totalData = (double)(creditorRepository.countCreditor(fullName));
        long totalPage = (long)(Math.ceil(totalData / rowsInPage));
        return totalPage;
    }

    @Override
    public void deleteCreditor(Integer id) {
        creditorRepository.deleteById(id);
    }

    @Override
    public Integer insertCreditor(InsertCreditorDTO dto) {
        String hashPassword = passwordEncoder.encode(dto.getPassword());
        String role = "Creditor";

        Account account = new Account(dto.getUsername(), hashPassword, role);
        Creditor creditor = new Creditor();
        creditor.setAccount(account);
        creditor.setFirstName(dto.getFirstName());
        creditor.setLastName(dto.getLastName());
        creditor.setAddress(dto.getAddress());
        creditor.setJobTitle(dto.getJobTitle());

        creditorRepository.save(creditor);

        return creditor.getId();
    }
}
