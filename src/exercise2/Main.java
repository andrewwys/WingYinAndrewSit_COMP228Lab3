package exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean finish = false;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Add a new game tester.");
            // Input name
            System.out.print("Enter name of tester: ");
            String name = input.nextLine();
            // Input hours of work
            int hour = 0;
            boolean invalidInput = false;
            try {
                System.out.print("How many hours did " + name + " worked? ");
                hour = input.nextInt();
                input.nextLine();
                // Input status full-time / part-time
                System.out.print("Is " + name + " a full-time tester? (y/n): ");
                String isFullTime = input.nextLine();
                // Create tester object
                GameTester gameTester;
                if (isFullTime.equals("y") || isFullTime.equals("Y")) {
                    gameTester = new FullTimeGameTester(name);
                } else {
                    gameTester = new PartTimeGameTester(name);
                }
                // Print results
                System.out.println("\n\nCreated a new Game Tester, " + gameTester.getName() + ".");
                System.out.print(gameTester.getName() + " is a ");
                if(gameTester.getStatus()) {
                    System.out.print("full-time");
                } else System.out.print("part-time");
                System.out.println(" tester,");
                System.out.println("whose salary is $" + gameTester.getSalary(hour) + ".\n\n");

                System.out.print("Add another tester? (y/n): ");
                String another = input.nextLine();
                if (!(another.equals("y") || another.equals("Y"))) {
                    finish = true;
                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine();
            }

        } while(!finish);
        System.out.println("End of program. Bye!");

    }
}