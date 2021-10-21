package exercise3;

public class PersonalMortgage extends Mortgage{

    // calculate personal mortgage rate
    private final static double interestRate = primeRate + 0.02;

    // constructor
    public PersonalMortgage(int mortgageNumber, String customerName, double amount, int term) {
        super(mortgageNumber,
                customerName,
                amount,
                interestRate,
                adjustTerm(term));
    }
}
