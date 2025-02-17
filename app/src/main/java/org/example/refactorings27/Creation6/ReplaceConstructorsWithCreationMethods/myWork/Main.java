package org.example.refactorings27.Creation6.ReplaceConstructorsWithCreationMethods.myWork;

import java.time.LocalDateTime;

public class Main {
    public void testTermLoanNoPayments() {
        double commitment = 0;
        int riskRating = 0;
        LocalDateTime maturity = LocalDateTime.now();
        Loan termLoan = Loan.createTermLoan(commitment, riskRating, maturity);
    }


    public void testTermLoanWithRiskAdjustedCapitalStrategy() {
        CapitalStrategy riskAdjustedCapitalStrategy = new RiskAdjustedCapitalStrategy();
        double commitment = 1000.0;
        double outstanding = 500.0;
        int riskRating = 3;
        LocalDateTime maturity = LocalDateTime.now();

        Loan termLoan = Loan.createTermLoan(riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity);

    }

    public static void main(String[] args) {
        System.out.println(
                "Hello, World!"
        );
    }

}
