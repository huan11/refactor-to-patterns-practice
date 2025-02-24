package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;


public class CapitalStrategy {
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


}
