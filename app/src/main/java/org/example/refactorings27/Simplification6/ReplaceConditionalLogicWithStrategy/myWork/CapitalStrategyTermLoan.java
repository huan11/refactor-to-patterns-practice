package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;

public class CapitalStrategyTermLoan extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.duration() * riskFactor(loan);
    }

    @Override
    public double duration(Loan loan) {
        return ((loan.getMaturity() == null) ? 0.0 : yearsTo(loan.getMaturity(), loan));
    }
}
