package org.example.refactorings27.Utilities3.ChainConstructors.initialCode;

import org.example.refactorings27.Utilities3.ChainConstructors.initialCode.CapitalStrategy;

import java.util.Date;

public class Loan {
    private final CapitalStrategy strategy;
    private float notional;
    private float outstanding;
    private int rating;
    private Date expiry;
    private Date maturity;

    public Loan(float notional, float outstanding, int rating, Date expiry) {
        this.strategy = new TermROC();
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
    }

    public Loan(float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this.strategy = new RevolvingTermROC();
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
        this.maturity = maturity;
    }

    public Loan(CapitalStrategy strategy, float notional, float outstanding, 
                int rating, Date expiry, Date maturity) {
        this.strategy = strategy;
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
        this.maturity = maturity;
    }

    public CapitalStrategy getCapitalStrategy() {
        return strategy;
    }
} 