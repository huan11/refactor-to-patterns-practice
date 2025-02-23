package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;

import org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.initialCode.Payment;
import org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.initialCode.RiskFactor;
import org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.initialCode.UnusedRiskFactors;

public class CapitalStrategy {
    public double capital() {
        if (expiry == null && maturity != null)
            return commitment * duration() * riskFactor();
        if (expiry != null && maturity == null) {
            if (getUnusedPercentage() != 1.0) {
                return commitment * getUnusedPercentage() * duration() * riskFactor();
            } else {
                return (outstandingRiskAmount() * duration() * riskFactor())
                        + (unusedRiskAmount() * duration() * unusedRiskFactor());
            }
        }
        return 0.0;
    }



    private double riskFactor() {
        return RiskFactor.getFactors().forRating(riskRating);
    }

    private double getUnusedPercentage() {
        return unusedPercentage;
    }

    private double outstandingRiskAmount() {
        return outstanding;
    }

    private double unusedRiskAmount() {
        return (commitment - outstanding);
    }

    private double unusedRiskFactor() {
        return UnusedRiskFactors.getFactors().forRating(riskRating);
    }


}
