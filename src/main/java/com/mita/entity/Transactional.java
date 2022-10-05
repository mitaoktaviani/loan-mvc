package com.mita.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Transactional")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class Transactional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID", nullable = false)
    private Integer id;

    @Column(name = "IsAccept")
    private Boolean isAccept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DebtorID")
    private Debtor debtorID;

    @Column(name = "LoanApplicationDate")
    private LocalDate loanApplicationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LoanID")
    private LoanOffer loanID;

    @Column(name = "IsPending")
    private Boolean isPending;

    @Column(name = "IsReject")
    private Boolean isReject;

}