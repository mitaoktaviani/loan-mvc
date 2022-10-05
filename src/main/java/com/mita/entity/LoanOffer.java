package com.mita.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "LoanOffers")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class LoanOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoanID", nullable = false)
    private Integer loanId;

    @Column(name = "LoanAmount", precision = 19, scale = 2)
    private BigDecimal loanAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID")
    private Category categoryID;

    @Column(name = "InterestRate")
    private String interestRate;

    @Column(name = "LoanName")
    private String loanName;

    @Column(name = "LoanTerm")
    private String loanTerm;

    @Column(name = "Repayment", precision = 19, scale = 2)
    private BigDecimal repayment;

    @Column(name = "TotalPayment", precision = 19, scale = 2)
    private BigDecimal totalPayment;

   }