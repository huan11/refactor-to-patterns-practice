package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;

public class CapitalStrategyRevolverLoan extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        if (loan.getUnusedPercentage(loan) != 1.0) {
            return loan.getCommitment() * loan.getUnusedPercentage(loan) * loan.duration() * riskFactor(loan);
        } else {
            return (loan.outstandingRiskAmount(loan) * loan.duration() * riskFactor(loan))
                    + (loan.unusedRiskAmount(loan) * loan.duration() * unusedRiskFactor(loan));
        }
    }
}
