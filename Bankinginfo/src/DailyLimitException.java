/**

 * The DailyLimitException class is a custom exception class that
 * extends the Exception class to handle exceptions that occur
 * when a withdrawal exceeds the daily withdrawal limit.
 *
 * @author [NAME]
 * @version 1.0
 * @since 2023-03-07
 */
public class DailyLimitException extends Exception {

    /**

     Constructs a new DailyLimitException with the specified detail message.
     @param message the detail message.
     */
    public DailyLimitException(String message) {
        super(message);
    }
}




