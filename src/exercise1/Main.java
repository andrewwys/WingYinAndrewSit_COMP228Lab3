package exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int num = 4; // the number of new insurance policy we are creating
        Scanner scanner = new Scanner(System.in);
        Insurance[] insuranceList = new Insurance[num];

        // repeat accepting input for new insurance
        for (int i = 0; i < num; i++) {
            System.out.print("Creating new insurance...\n");
            Insurance insurance;
            double fee = 0;
            boolean validFeeInput;
            boolean validTypeInput;

            //repeat until Type and Fee inputs are correct
            do {
                validFeeInput = true;
                validTypeInput = false;
                System.out.print("Enter type of insurance: ");
                String type = scanner.nextLine();
                System.out.print("Enter monthly fee: ");
                try {
                    fee = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.print("Enter a number for fee. ");
                    validFeeInput = false;
                }

                scanner.nextLine();

                // before creating new insurance, check correct input
                if ((type.equals("Health") || type.equals("HEALTH") || type.equals("health")) && validFeeInput) {
                    insurance = new Health();
                    insuranceList[i] = insurance;
                    validTypeInput = true;
                } else if ((type.equals("Life") || type.equals("LIFE") || type.equals("life")) && validFeeInput) {
                    insurance = new Life();
                    insuranceList[i] = insurance;
                    validTypeInput = true;
                } else System.out.println("Invalid input, please try again.");
            } while(!(validTypeInput && validFeeInput));

            System.out.println("Successfully created!");
            // Polymorphism: Accessing method through superclass.
            insuranceList[i].setInsuranceCost(fee);
            insuranceList[i].displayInfo();
        }

        System.out.println("The end of program. Thank you!");
        scanner.close();
    }
}
