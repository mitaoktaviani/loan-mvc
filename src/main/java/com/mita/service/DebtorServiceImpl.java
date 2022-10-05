package com.mita.service;

import com.mita.dto.debtor.RegisterDebtor;
import com.mita.entity.Account;
import com.mita.entity.Debtor;
import com.mita.repository.AccountRepository;
import com.mita.repository.DebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DebtorServiceImpl implements DebtorService{

    @Autowired
    private DebtorRepository debtorRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerAccount(RegisterDebtor dto) {
        String role ="Debtor";
        String hashPassword = passwordEncoder.encode(dto.getPassword());

        Account account = new Account(dto.getUsername(), hashPassword, role);

        accountRepository.save(account);

        Debtor debtor = new Debtor();
        debtor.setAccount(account);
        debtor.setAddress(dto.getAddress());
        debtor.setAge(dto.getAge());
        debtor.setCompany(dto.getCompany());
        debtor.setFirstName(dto.getFirstName());
        debtor.setContactNumber(dto.getContactNumber());
        debtor.setGender(dto.getGender());
        debtor.setLastName(dto.getLastName());
        debtor.setIDCardNumber(dto.getIdCardNumber());
        debtor.setProfessions(dto.getProfession());

        debtorRepository.save(debtor);
    }
}
