package com.mita.service;

import com.mita.dto.creditor.CreditorDTO;
import com.mita.dto.creditor.InsertCreditorDTO;

import java.util.List;

public interface CreditorService {
    List<CreditorDTO> getAll(Integer page, String fullName);

    long getTotalPages(String fullName);

    void deleteCreditor(Integer id);

    Integer insertCreditor(InsertCreditorDTO dto);
}
