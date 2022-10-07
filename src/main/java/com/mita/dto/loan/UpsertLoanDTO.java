package com.mita.dto.loan;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter @Setter
public class UpsertLoanDTO {
    private Integer loanId;
    @NotBlank(message = "Category is required")
    private Integer categoryId;
    @NotBlank(message = "Loan Name is required")
    private String loanName;
    @NotNull(message = "Loan Amount is required")
    private BigDecimal loanAmount;
    @NotBlank(message = "Interest Rate is required")
    private String interestRate;
    @NotBlank(message = "Loan Term is required")
    private String loanTerm;
    @NotNull(message = "Repayment is required")
    private BigDecimal repayment;
    @NotNull(message = "Total Payment is required")
    private BigDecimal totalPayment;

}
