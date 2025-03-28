package org.example.refactorings27.Creation6.ReplaceConstructorsWithCreationMethods.initialCode;

import java.time.LocalDateTime;

public class Main {
    public void testTermLoanNoPayments() {
        double commitment = 0;
        int riskRating = 0;
        LocalDateTime maturity = LocalDateTime.now();
        Loan termLoan = new Loan(commitment, 0.00, riskRating, maturity, null);
    }


    public void testTermLoanWithRiskAdjustedCapitalStrategy() {
        CapitalStrategy riskAdjustedCapitalStrategy = new RiskAdjustedCapitalStrategy();
        double commitment = 1000.0;
        double outstanding = 500.0;
        int riskRating = 3;
        LocalDateTime maturity = LocalDateTime.now();

        Loan termLoan = new Loan(riskAdjustedCapitalStrategy, commitment,
                outstanding, riskRating, maturity, null);

    }

}
