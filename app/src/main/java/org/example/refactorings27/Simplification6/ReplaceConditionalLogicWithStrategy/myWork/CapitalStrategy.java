package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;


import java.util.Date;

public class CapitalStrategy {
    private static final long MILLIS_PER_DAY = 86400000;
    private static final long DAYS_PER_YEAR = 365;

    public double capital(Loan loan) {
        if (loan.getExpiry() == null && loan.getMaturity() != null)
            return loan.getCommitment() * loan.duration() * riskFactor(loan);
        if (loan.getExpiry() != null && loan.getMaturity() == null) {
            if (loan.getUnusedPercentage(loan) != 1.0) {
                return loan.getCommitment() * loan.getUnusedPercentage(loan) * loan.duration() * riskFactor(loan);
            } else {
                return (loan.outstandingRiskAmount(loan) * loan.duration() * riskFactor(loan))
                        + (loan.unusedRiskAmount(loan) * loan.duration() * unusedRiskFactor(loan));
            }
        }
        return 0.0;
    }



    private double riskFactor(Loan loan) {
        return RiskFactor.getFactors().forRating(loan.getRiskRating());
    }


    private double unusedRiskFactor(Loan loan) {
        return UnusedRiskFactors.getFactors().forRating(loan.getRiskRating());
    }



    public double duration(Loan loan) {
//        if (expiry == null && maturity != null) {
        if (loan.getExpiry() == null && loan.getMaturity() != null) {
            return weightedAverageDuration(loan);
        } else if (loan.getExpiry()  != null && loan.getMaturity() == null) {
            return yearsTo(loan.getExpiry(),loan);
        }
        return 0.0;
    }

    private double weightedAverageDuration(Loan loan) {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;

        for (Payment payment : loan.getPayments()) {
            sumOfPayments += payment.getAmount();
            weightedAverage += yearsTo(payment.getDate(),loan) * payment.getAmount();
        }

        if (loan.getCommitment() != 0.0) {
            duration = weightedAverage / sumOfPayments;
        }

        return duration;
    }

    private double yearsTo(Date endDate, Loan loan) {
        Date beginDate = (loan.getToday() == null ? loan.getStart() : loan.getToday());
        return (double) ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY / DAYS_PER_YEAR);
    }

}
