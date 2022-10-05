package com.mita.repository;

import com.mita.entity.Creditor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditorRepository extends JpaRepository<Creditor, Integer> {
}