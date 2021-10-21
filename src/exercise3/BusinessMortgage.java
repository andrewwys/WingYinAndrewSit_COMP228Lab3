package exercise3;

public class BusinessMortgage extends Mortgage{

    // calculate business mortgage rate
    private final static double interestRate = primeRate + 0.01;

    // constructor
    public BusinessMortgage(int mortgageNumber, String customerName, double amount, int term) {
        super(mortgageNumber,
                customerName,
                amount,
                interestRate,
                adjustTerm(term));
    }
}
