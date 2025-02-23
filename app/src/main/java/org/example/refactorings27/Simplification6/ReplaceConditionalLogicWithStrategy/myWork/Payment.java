package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;

import java.util.Date;

public class Payment {
    private double amount;
    private Date date;

    public Payment() {
        this.amount = 0.0;
        this.date = new Date();
    }

    public Payment(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
} 