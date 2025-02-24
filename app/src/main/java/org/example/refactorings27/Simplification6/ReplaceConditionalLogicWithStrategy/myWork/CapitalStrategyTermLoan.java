package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;

public class CapitalStrategyTermLoan extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.duration() * riskFactor(loan);
    }

    @Override
    public double duration(Loan loan) {
        return weightedAverageDuration(loan);
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
}
