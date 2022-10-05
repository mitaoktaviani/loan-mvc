package com.mita.repository;

import com.mita.entity.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionalRepository extends JpaRepository<Transactional, Integer> {
}