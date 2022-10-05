package com.mita.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TransactionDetail")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionDetailID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreditorID")
    private Creditor creditorID;

    @Column(name = "Instalment")
    private Integer instalment;

    @Column(name = "IsPaid")
    private Boolean isPaid;

    @Column(name = "PayAmount", precision = 19, scale = 2)
    private BigDecimal payAmount;

    @Column(name = "PaymentDueDate")
    private LocalDate paymentDueDate;

    @Column(name = "Term")
    private String term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TransactionID")
    private Transactional transactionID;

    }