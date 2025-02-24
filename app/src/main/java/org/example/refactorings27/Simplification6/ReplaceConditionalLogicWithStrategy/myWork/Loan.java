package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loan {
    private double commitment = 1.0;
    private Date expiry;
    private Date maturity;
    private double outstanding;
    private List<Payment> payments = new ArrayList<>();
    private Date today = new Date();
    private Date start;
    private static final long MILLIS_PER_DAY = 86400000;
    private static final long DAYS_PER_YEAR = 365;
    private double riskRating;
    private double unusedPercentage;

    public Loan(double commitment, double notSureWhatThisIs, Date start, Date expiry, Date maturity, int riskRating) {
        this.expiry = expiry;
        this.commitment = commitment;
        this.today = null;
        this.start = start;
        this.maturity = maturity;
        this.riskRating = riskRating;
        this.unusedPercentage = 1.0;
    }

    public static Loan newTermLoan(double commitment, Date start, Date maturity, int riskRating) {
        return new Loan(commitment, commitment, start, null, maturity, riskRating);
    }

    public static Loan newRevolver(double commitment, Date start, Date expiry, int riskRating) {
        return new Loan(commitment, 0, start, expiry, null, riskRating);
    }

    public static Loan newAdvisedLine(double commitment, Date start, Date expiry, int riskRating) {
        if (riskRating > 3) return null;
        Loan advisedLine = new Loan(commitment, 0, start, expiry, null, riskRating);
        advisedLine.setUnusedPercentage(0.1);
        return advisedLine;
    }

    public void payment(double amount, Date paymentDate) {
        payments.add(new Payment(amount, paymentDate));
    }

    public double capital() {
    }




    public double duration() {
        if (expiry == null && maturity != null) {
            return weightedAverageDuration();
        } else if (expiry != null && maturity == null) {
            return yearsTo(expiry);
        }
        return 0.0;
    }

    private double weightedAverageDuration() {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;

        for (Payment payment : payments) {
            sumOfPayments += payment.getAmount();
            weightedAverage += yearsTo(payment.getDate()) * payment.getAmount();
        }

        if (commitment != 0.0) {
            duration = weightedAverage / sumOfPayments;
        }

        return duration;
    }




    private double yearsTo(Date endDate) {
        Date beginDate = (today == null ? start : today);
        return (double) ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY / DAYS_PER_YEAR);
    }

    double outstandingRiskAmount(Loan loan) {
        return loan.getOutstanding();
    }

    double unusedRiskAmount(Loan loan) {
        return (loan.getCommitment() - loan.getOutstanding());
    }
    double getUnusedPercentage(Loan loan) {
        return loan.getUnusedPercentage();
    }




    public void setUnusedPercentage(double unusedPercentage) {
        this.unusedPercentage = unusedPercentage;
    }


    public double getOutstanding() {
        return outstanding;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getMaturity() {
        return maturity;
    }

    public double getCommitment() {
        return commitment;
    }

    public double getRiskRating() {
        return riskRating;
    }

    public double getUnusedPercentage() {
        return unusedPercentage;
    }
}