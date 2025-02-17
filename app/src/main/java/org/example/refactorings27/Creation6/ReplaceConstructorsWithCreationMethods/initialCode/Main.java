package org.example.refactorings27.Creation6.ReplaceConstructorsWithCreationMethods.initialCode;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        double commitment = 0;
        int riskRating = 0;
        LocalDateTime maturity = LocalDateTime.now();
        Loan termLoan = Loan.createTermLoan(commitment, riskRating, maturity);
    }

}
