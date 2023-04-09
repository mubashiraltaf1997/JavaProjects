import java.util.Scanner;

/**
 An exception that is thrown when the input balance value is not in the correct format.

 This exception extends the Exception class.
 */
public class MalformedBalanceException extends Exception {

    /**

     Constructs a new MalformedBalanceException with the specified detail message.
     @param message the detail message.
     */
    MalformedBalanceException(String message) {
        super(message);
    }

    private static double getDouble() throws MalformedBalanceException {
        try {
            double balance = Double.parseDouble(new Scanner(System.in).nextLine());
            return balance;
        } catch (NumberFormatException e) {
            // Risk guidance: Catching exception and returning custom error message to avoid exposing system internals to attacker
            throw new MalformedBalanceException("Invalid input. Please enter a number.");
        }
    }



}