import java.util.Scanner;

/**.
* This program will check if the user years worked is more than 5
* And display the salary with a 5% increase if it is.
*
* @author  Remy Skelton
* @version 1.0
* @since   2025-March-3
*/

final class Salary {

    /**.
     * Set MAX_YEARS int constant to 90
     */
    public static final double MAX_YEARS = 90;

    /**.
     * Set BONUS double constant to 5%
     */
    public static final double BONUS = 0.05;

    /**
    * This is a private constructor used to satisfy the style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private Salary() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the main method.
    *
    * @param args Unused.
    */
    public static void main(final String[] args) {
        // Welcome message and instructions
        System.out.println("This program will ask for the number of years"
                + " you have worked as well as your salary and if you have"
                + " worked more than 5 years you will get a 5% increase.");

        // Use a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Declare userYearsInt and userSalaryDouble
        int userYearsInt = 0;
        double userSalaryDouble = 0;

        // Do-while loop for valid salary input
        do {
            // Message for user to enter salary
            System.out.println("Please enter your annual salary: ");

            // Get user salary string
            String userSalaryString = scanner.nextLine();

            // Try-catch block for non-numeric input
            try {
                // Convert user salary to double
                userSalaryDouble = Double.parseDouble(userSalaryString);

                // Check if salary is less than or equal to 0
                if (userSalaryDouble <= 0) {
                    // Display error message when salary is
                    // Less than or equal to 0
                    System.out.println("Invalid input: " + userSalaryString
                            + ". Please enter a salary greater than 0.");
                }
            } catch (NumberFormatException error) {
                // Display error message when salary is not a number
                System.out.println("Invalid input: " + userSalaryString
                        + ". Please enter a salary greater than 0.");
            }

        // Runs until user salary is greater than 0
        } while (userSalaryDouble <= 0);

        // While loop for valid number of years worked is entered
        while (userYearsInt <= 0 || userYearsInt > MAX_YEARS) {
            // Message for user to enter years worked
            System.out.println("Please enter the number "
                + "of years you have worked: ");

            // Get user years string for years worked
            String userYearsString = scanner.nextLine();

            // Try-catch block for non-numeric and decimal input
            try {
                // Convert user years to integer
                userYearsInt = Integer.parseInt(userYearsString);

                // Check if years worked is
                // Less than or equal to 0
                if (userYearsInt <= 0 || userYearsInt > MAX_YEARS) {
                    // Display error message when years worked
                    // Is less than or equal to 0 or greater than 90
                    System.out.println("Invalid input: " + userYearsString
                            + ". Please enter a number of years "
                            + "greater than 0 and less than 90.");
                }

            } catch (NumberFormatException error) {
                // Display error message when input
                // Is not a number or is a decimal
                System.out.println("Invalid input: " + userYearsString
                        + ". Please enter a number of "
                        + "years greater than 0 and less than 90.");
            }
        }

        // Calculate salary and bonus by calling calculateSalary method
        // Store results in results array as it contains more than one value
        // Learnt methods in java from class
        // Learnt how to use arrays in java
        // From https://www.w3schools.com/java/java_arrays.asp
        double[] resultsDoubleArray
                = calculateSalary(userYearsInt, userSalaryDouble);
        // Get bonusTotal and salaryTotal from results array
        double bonusTotal = resultsDoubleArray[0];
        double salaryTotal = resultsDoubleArray[1];

        // Display results based on number of years worked
        if (userYearsInt > 5) {
            // Display bonus and salary
            System.out.print("The bonus amount after "
            + userYearsInt + " years is ");
            System.out.format("%.2f", bonusTotal);
            System.out.println("$.");
            System.out.print("Your total income before taxes is ");
            System.out.format("%.2f", salaryTotal);
            System.out.println("$.");
        } else {
            // Display salary without qualifying for bonus
            System.out.println(userYearsInt
                    + " years does not qualify for a bonus,"
                    + " your total income before taxes is ");
            System.out.format("%.2f", salaryTotal);
            System.out.println("$.");
        }

        // Close scanner
        scanner.close();
    }

    /**
    * This method calculates the salary and bonus.
    *
    * @param userYearsInt The number of years worked.
    * @param userSalaryDouble The user's annual salary.
    * @return An array containing bonusTotal and salaryTotal.
    */
    public static double[] calculateSalary(
            final int userYearsInt, final double userSalaryDouble
        ) {

        // Declare bonusTotal and salaryTotal
        double bonusTotal = 0;
        double salaryTotal = 0;

        // Switch statement to determine bonus percentage
        // Learnt switch statements in java
        // from https://www.w3schools.com/java/java_switch.asp
        switch (userYearsInt) {
            case 1:
                // No bonus for less than 6 years
                bonusTotal = 0;
                salaryTotal = userSalaryDouble;
                break;
            case 2:
                // No bonus for less than 6 years
                bonusTotal = 0;
                salaryTotal = userSalaryDouble;
                break;
            case 3:
                // No bonus for less than 6 years
                bonusTotal = 0;
                salaryTotal = userSalaryDouble;
                break;
            case 4:
                // No bonus for less than 6 years
                bonusTotal = 0;
                salaryTotal = userSalaryDouble;
                break;
            case 5:
                // No bonus for less than 6 years
                bonusTotal = 0;
                salaryTotal = userSalaryDouble;
                break;
            default:
                // 5% bonus for more than 5 years
                bonusTotal = userSalaryDouble * BONUS;
                salaryTotal = bonusTotal + userSalaryDouble;
                break;
        }

    // Make array with bonusTotal and salaryTotal
    double[] bonusSalaryArray = new double[] {bonusTotal, salaryTotal};

    // Return bonusTotal and salaryTotal in a double array
    return bonusSalaryArray;
    }
}
