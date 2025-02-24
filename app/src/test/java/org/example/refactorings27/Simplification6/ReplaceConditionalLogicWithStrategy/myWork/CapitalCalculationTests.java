package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class CapitalCalculationTests {
    private static final double LOAN_AMOUNT = 1000.0;
    private static final double TWO_DIGIT_PRECISION = 0.01;
    private static final int HIGH_RISK_RATING = 1;

    @Test
    public void testTermLoanSamePayments() {
        Date start = november(20, 2003);
        Date maturity = november(20, 2006);
        Loan termLoan = Loan.newTermLoan(LOAN_AMOUNT, start, maturity, HIGH_RISK_RATING);
        
        termLoan.payment(1000.00, november(20, 2004));
        termLoan.payment(1000.00, november(20, 2005));
        termLoan.payment(1000.00, november(20, 2006));
        
        assertEquals(2.0, termLoan.duration(), TWO_DIGIT_PRECISION, "duration");
        assertEquals(210.00, termLoan.capital(), TWO_DIGIT_PRECISION, "capital");
    }

    private Date november(int day, int year) {
        // Note: Month in Java's Date is 0-based, so November is 10
        return new Date(year - 1900, 10, day);
    }
} 