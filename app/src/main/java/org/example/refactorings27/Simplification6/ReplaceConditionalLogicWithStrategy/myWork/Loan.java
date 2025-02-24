package org.example.refactorings27.Simplification6.ReplaceConditionalLogicWithStrategy.myWork;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loan {
    private final CapitalStrategy capitalStrategy;
    private double commitment = 1.0;
    private Date expiry;
    private Date maturity;
    private double outstanding;
    private List<Payment> payments = new ArrayList<>();
    private Date today = new Date();
    private Date start;

    private double riskRating;
    private double unusedPercentage;

    public Loan(double commitment, double notSureWhatThisIs, Date start, Date expiry, Date maturity, int riskRating, CapitalStrategy capitalStrategy) {
        this.expiry = expiry;
        this.commitment = commitment;
        this.today = null;
        this.start = start;
        this.maturity = maturity;
        this.riskRating = riskRating;
        this.unusedPercentage = 1.0;
        this.capitalStrategy = capitalStrategy;
    }

    public static Loan newTermLoan(double commitment, Date start, Date maturity, int riskRating) {
        return new Loan(commitment, commitment, start, null, maturity, riskRating, new CapitalStrategy());
    }

    public static Loan newRevolver(double commitment, Date start, Date expiry, int riskRating) {
        return new Loan(commitment, 0, start, expiry, null, riskRating, new CapitalStrategy());
    }

    public static Loan newAdvisedLine(double commitment, Date start, Date expiry, int riskRating) {
        if (riskRating > 3) return null;
        Loan advisedLine = new Loan(commitment, 0, start, expiry, null, riskRating, new CapitalStrategy());
        advisedLine.setUnusedPercentage(0.1);
        return advisedLine;
    }

    public void payment(double amount, Date paymentDate) {
        payments.add(new Payment(amount, paymentDate));
    }

    public double capital() {
        return capitalStrategy.capital(this);
    }




    public double duration() {
        return capitalStrategy.duration(this);
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

    public List<Payment> getPayments() {
        return payments;
    }

    public Date getToday() {
        return today;
    }

    public Date getStart() {
        return start;
    }
}