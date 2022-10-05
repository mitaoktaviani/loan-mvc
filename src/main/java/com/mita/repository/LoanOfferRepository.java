package com.mita.repository;

import com.mita.entity.LoanOffer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanOfferRepository extends JpaRepository<LoanOffer, Integer> {
    @Query(value = """
            SELECT * FROM LoanOffers AS lo
            WHERE lo.LoanName LIKE %?1%
            """, nativeQuery = true)
    List<LoanOffer> getAll(@Param("loanName") String loanName, Pageable pagination);

    @Query(value = """
            SELECT COUNT(*) FROM LoanOffers AS lo
            WHERE lo.LoanName LIKE %?1%
            """, nativeQuery = true)
    long countLoan(@Param("loanName") String loanName);
}