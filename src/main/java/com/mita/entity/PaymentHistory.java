package com.mita.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PaymentHistory")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter @ToString
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HistoryPaymentID", nullable = false)
    private Integer id;

    @Column(name = "Instalment")
    private Integer instalment;

    @Column(name = "TotalPaid", precision = 19, scale = 2)
    private BigDecimal totalPaid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TransactionDetailID")
    private TransactionDetail transactionDetailID;

    @Column(name = "PaidDate")
    private LocalDate paidDate;

}