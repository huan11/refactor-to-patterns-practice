package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;


import java.util.Date;

public abstract class CapitalStrategy {
    private static final long MILLIS_PER_DAY = 86400000;
    private static final long DAYS_PER_YEAR = 365;

    public abstract double capital(Loan loan);



    protected double riskFactor(Loan loan) {
        return RiskFactor.getFactors().forRating(loan.getRiskRating());
    }


    protected double unusedRiskFactor(Loan loan) {
        return UnusedRiskFactors.getFactors().forRating(loan.getRiskRating());
    }



    public double duration(Loan loan) {
        return yearsTo(loan.getExpiry(),loan);
    }



    protected double yearsTo(Date endDate, Loan loan) {
        Date beginDate = (loan.getToday() == null ? loan.getStart() : loan.getToday());
        return (double) ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY / DAYS_PER_YEAR);
    }

}
