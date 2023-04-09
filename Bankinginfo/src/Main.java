
// Sensitive data:
// - Owner name entered by the user (may contain personal information)
// - Account number entered by the user (should be kept confidential)
// - Balance, deposit and withdrawal amounts (financial data that should be protected)
// - Overdraft limit (financial data that should be protected)
// - Interest rate (financial data that should be protected)
// - Exceptions messages (may reveal sensitive information to potential attackers)
// Risk guidance from CMU's SEI:
// - Sensitive data should be encrypted and protected during storage and transmission
// - Access to sensitive data should be restricted to authorized personnel only
// - Exception messages should not reveal sensitive information to potential attackers.
//   Instead, they should provide generic error messages to users while logging detailed error messages for debugging purposes.


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        List<Account_W2023_Champions> accounts = new ArrayList<>();

        System.out.println("Select the account type you want to create:\n1. Checking Account\n2. Savings Account ");
        int option = 0;
        try {
            option = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(0);
        }

        switch (option) {
            case 1:
                Account_W2023_Champions newCheckingAccount = createCheckingAccount(in);
                accounts.add(newCheckingAccount);
                break;

            case 2:
                Account_W2023_Champions newSavingsAccount = createSavingsAccount(in);
                accounts.add(newSavingsAccount);
                break;

            default:
                System.out.println("You have selected an incorrect option");
                System.exit(0);
        }

        System.out.println("Enter amount to deposit from the account:");
        try {
            double depositAmount = getDouble(in);
            Account_W2023_Champions account = accounts.get(0);
            account.deposit(depositAmount);
        } catch (MalformedBalanceException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        System.out.println("Enter amount to withdraw from the account:");
        try {
            double withdrawalAmount = getDouble(in);
            Account_W2023_Champions account = accounts.get(0);
            account.withdraw(withdrawalAmount);

        } catch (MalformedBalanceException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (DailyLimitException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        // Monthly auditing
        System.out.println("Monthly Auditing Report:");
        for (Account_W2023_Champions account : accounts) {
            System.out.println(account.toString());
        }
    }

    private static Account_W2023_Champions createCheckingAccount(Scanner in) throws Exception {
        System.out.println("Enter Owner Name:");
        String ownerName = in.nextLine();
        System.out.println("Enter balance:");
        double balance = getDouble(in);
        System.out.println("Enter Account Number:");
        String accountNumber = in.nextLine();
        System.out.println("Enter overdraft limit:");
        double overdraftLimit = getDouble(in);
        return new Checking_W2023_Champions(accountNumber, balance, LocalDate.now().toString(), ownerName, overdraftLimit);
    }

    private static Account_W2023_Champions createSavingsAccount(Scanner in) throws Exception {
        System.out.println("Enter Owner Name:");
        String ownerName = in.nextLine();
        System.out.println("Enter balance:");
        double balance = getDouble(in);
        System.out.println("Enter Account Number:");
        String accountNumber = in.nextLine();
        System.out.println("Enter interestRate:");
        double interestRate = getDouble(in);
        return new Savings_W2023_Champions(accountNumber, balance, LocalDate.now().toString(), ownerName, interestRate);
    }

    private static double getDouble(Scanner in) throws MalformedBalanceException {
        try {
            double balance = Double.parseDouble(in.nextLine());
            return balance;
        } catch (NumberFormatException e) {
            throw new MalformedBalanceException("Invalid input. Please enter a number.");
        }
    }


}