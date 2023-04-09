import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StockAccounting {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Queue<StockRecord> fifoQueue = new LinkedList<>();
        Stack<StockRecord> lifoStack = new Stack<>();

        while (true) {
            System.out.println("Press 1 to enter a stock sale");
            System.out.println("Press 2 to find the Lifo and Fifo price for a stock");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the stock symbol:");
                    String symbol = scanner.next();
                    System.out.println("Enter the number of shares sold:");
                    int sharesSold = scanner.nextInt();
                    System.out.println("Enter the total price:");
                    double totalPrice = scanner.nextDouble();

                    StockRecord stock = new StockRecord(symbol, sharesSold, totalPrice);
                    fifoQueue.add(stock);
                    lifoStack.push(stock);
                    System.out.println("Stock sale added successfully!");
                    break;

                case 2:
                    System.out.println("Enter the stock symbol:");
                    String symbolQuery = scanner.next();
                    System.out.println("Enter the number of shares:");
                    int sharesQuery = scanner.nextInt();

                    double fifoPrice = getFifoPrice(fifoQueue, symbolQuery, sharesQuery);
                    double lifoPrice = getLifoPrice(lifoStack, symbolQuery, sharesQuery);

                    System.out.println("Fifo price for " + sharesQuery + " shares of " + symbolQuery + ": $" + fifoPrice);
                    System.out.println("Lifo price for " + sharesQuery + " shares of " + symbolQuery + ": $" + lifoPrice);
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        }
    }

    private static double getFifoPrice(Queue<StockRecord> fifoQueue, String symbol, int shares) {
        double totalCost = 0.0;
        int remainingShares = shares;

        while (remainingShares > 0 && !fifoQueue.isEmpty()) {
            StockRecord stock = fifoQueue.peek();
            if (stock.getSymbol().equals(symbol)) {
                int sharesToUse = Math.min(stock.getSharesBought(), remainingShares);
                totalCost += (sharesToUse * stock.getPurchasePrice()) / stock.getSharesBought();
                remainingShares -= sharesToUse;
                if (sharesToUse == stock.getSharesBought()) {
                    fifoQueue.poll();
                } else {
                    stock.setSharesBought(stock.getSharesBought() - sharesToUse);
                }
            } else {
                fifoQueue.poll();
            }
        }

        return (remainingShares == 0) ? totalCost : -1.0;
    }

    private static double getLifoPrice(Stack<StockRecord> lifoStack, String symbol, int shares) {
        double totalCost = 0.0;
        int remainingShares = shares;

        while (remainingShares > 0 && !lifoStack.isEmpty()) {
            StockRecord stock = lifoStack.peek();
            if (stock.getSymbol().equals(symbol)) {
                int sharesToUse = Math.min(stock.getSharesBought(), remainingShares);
                totalCost += (sharesToUse * stock.getPurchasePrice()) / stock.getSharesBought();
                remainingShares -= sharesToUse;
                if (sharesToUse == stock.getSharesBought()) {
                    lifoStack.pop();
                } else {
                    stock.setSharesBought(stock.getSharesBought() - sharesToUse);
                }
            } else {
                lifoStack.pop();
            }
        }

        return (remainingShares == 0) ? totalCost : -1.0;
    }
}
