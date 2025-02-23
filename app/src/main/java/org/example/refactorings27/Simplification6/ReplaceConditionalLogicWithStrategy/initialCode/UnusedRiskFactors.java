package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.initialCode;

public class UnusedRiskFactors {
    private UnusedRiskFactors() {
    }

    public static UnusedRiskFactors getFactors() {
        return new UnusedRiskFactors();
    }

    public double forRating(double riskRating) {
        return 0.01;
    }
} 