package exercise3;

import java.lang.Math;
import java.text.DecimalFormat;

public abstract class Mortgage implements MortgageConstants {

    protected int mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(int mortgageNumber, String customerName, double amount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
    }

    protected void getMortgageInfo() {
        // set format for decimal number
        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);

        System.out.println("############################################");
        System.out.println();
        System.out.println("Display information for mortgage number: " + mortgageNumber);
        System.out.println("Mortgage Type: " + this.getClass().getSimpleName());
        System.out.println("Customer name: " + customerName);
        System.out.println("Amount of mortgage: $" + df.format(amount));
        System.out.println("Interest rate: " + df.format(interestRate * 100) + "%");
        System.out.println("Term (year): "+ term);
        System.out.println();
        System.out.print("Total amount owed: $");
        // Calculate amount plus compound interest
        System.out.println(df.format(amount * Math.pow((1 + interestRate), term)));
        System.out.println();
    }

    // Don’t allow mortgage amounts over $300,000.
    public static boolean validAmount(double amount) {
        return amount <= maxAmount;
    }

    // Force any mortgage term that is not defined in the MortgageConstants interface to a short-term, one-year loan.
    protected static int adjustTerm(int inputTerm) {
        if ( inputTerm == shortTerm || inputTerm == mediumTerm || inputTerm == longTerm ) {
            return inputTerm;
        } else return 1;
    }
}
