package org.example.refactorings27.Creation6.ReplaceConstructorsWithCreationMethods.initialCode;

import java.time.LocalDateTime;

public class Loan {
    private double commitment;
    private final double outstanding;
    private final int riskRating;
    private final LocalDateTime maturity;
    private final LocalDateTime expiry;
    private final CapitalStrategy capitalStrategy;

    public Loan(double commitment, int riskRating, LocalDateTime maturity) {
        this(commitment, 0.00, riskRating, maturity, null);
    }

    public Loan(double commitment, int riskRating, LocalDateTime maturity, LocalDateTime expiry) {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(double commitment, double outstanding, int riskRating, LocalDateTime maturity, LocalDateTime expiry) {
        this(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, int riskRating, LocalDateTime maturity, LocalDateTime expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    private Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, LocalDateTime maturity, LocalDateTime expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        
        if (capitalStrategy == null) {
            if (expiry == null) {
                this.capitalStrategy = new CapitalStrategyTermLoan();
            } else if (maturity == null) {
                this.capitalStrategy = new CapitalStrategyRevolver();
            } else {
                this.capitalStrategy = new CapitalStrategyRCTL();
            }
        } else {
            this.capitalStrategy = capitalStrategy;
        }
    }

    public static Loan createTermLoan(double commitment, int riskRating, LocalDateTime maturity) {
        return new Loan(commitment, 0.00, riskRating, maturity, null);
    }

    public static Loan createTermLoan(CapitalStrategy riskAdjustedCapitalStrategy, double commitment, double outstanding, int riskRating, LocalDateTime maturity) {
        return new Loan(riskAdjustedCapitalStrategy, commitment,
                outstanding, riskRating, maturity, null);
    }

    public CapitalStrategy getCapitalStrategy() {
        return capitalStrategy;
    }
} 