package com.mita.repository;

import com.mita.dto.creditor.CreditorDTO;
import com.mita.entity.Creditor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CreditorRepository extends JpaRepository<Creditor, Integer> {
    @Query("""
            SELECT new com.mita.dto.creditor.CreditorDTO(
            cre.id, CONCAT(cre.firstName,' ',cre.lastName),acc.username, cre.address, cre.jobTitle)
            FROM Creditor AS cre
            JOIN cre.account as acc
            WHERE CONCAT(cre.firstName,' ',cre.lastName) LIKE %:fullName%
            """)
    List<CreditorDTO> getAll(@Param("fullName") String fullName, Pageable pagination);

    @Query("""
            SELECT COUNT(*)
            FROM Creditor AS cre
            WHERE CONCAT(cre.firstName,' ',cre.lastName) LIKE %:fullName%
            """)
    long countCreditor(String fullName);
}