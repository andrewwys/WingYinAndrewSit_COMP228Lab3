package exercise3;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcessMortgage {

    public static void main(String[] args) {

        // set format for decimal number
        DecimalFormat df = new DecimalFormat("#.##");

        // Number of mortgage record to be created
        int n = 3;

        Mortgage[] mortgages = new Mortgage[n];
        // Prompt the user for the current interest rate
        System.out.println("Current prime interest rate is: " + df.format(Mortgage.primeRate * 100) + "%");
        Scanner input = new Scanner(System.in);

        // create an array of 3 mortgages.
        for (int i=0; i<n; i++) {
            boolean validInput;
            System.out.println("#########################################");
            System.out.println("Create new mortgage - no." + Integer.toString(i+1));
            int mortgageType = 1;
            int mortgageNumber = 0;
            String customerName = "";
            double amount = 0;
            int term = 1;

            // Loop until inputs are valid for a single mortgage entry.
            do {
                validInput = true;
                try {
                    // Loop until mortgageType = 1 or 2
                    do {
                        System.out.print("Input mortgage type (1 = Business, 2 = Personal): ");
                        mortgageType = input.nextInt();
                        input.nextLine();
                    } while (!(mortgageType == 1 || mortgageType == 2));
                    System.out.print("Input mortgage number: ");
                    mortgageNumber = input.nextInt();
                    input.nextLine();
                    System.out.print("Input customer name: ");
                    customerName = input.nextLine();
                    boolean validAmount = false;

                    // Ask for mortgage amount and check
                    while(!validAmount) {
                        System.out.print("Input mortgage amount($): ");
                        amount = input.nextDouble();
                        input.nextLine();
                        if (!Mortgage.validAmount(amount)) {
                            System.out.println("Mortgage amount exceed $300,000.");
                        } else validAmount = true;
                    }
                    System.out.print("Input mortgage term (year): ");
                    term = input.nextInt();
                    input.nextLine();
                } catch(InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Invalid input, please try again.");
                    validInput = false;
                }
            } while (!validInput);

            // Create personal or business mortgage depending on type input
            // Store the created Mortgage objects in the array.
            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, term);
            } else {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, term);
            }
        }

        // display all mortgages.
        for (int i=0; i<n; i++) {
            mortgages[i].getMortgageInfo();
        }
    }
}