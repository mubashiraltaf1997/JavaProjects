Companies and people often buy and sells stocks.  Often they buy the same stock for different prices at different times.  Say a person owns 1000 shares a certain stock (such as Microsoft), he/she may have bought the stock in amounts of 100 shares over 10 different times with 10 different prices.

We will implement a java program for two different methods of accounting -- Fifo and Lifo accounting used for determining the "cost" of a stock.  This information is typically calculated when a stock is sold to determined if a profit / loss was made.  In our version of Fifo accounting, the price of a commodity is averaged starting with the first purchase of that item.  e.g. if we sell 250 shares of a stock, according to this method, the purchase price is determined by averaging the prices on the first 250 shares bought.  In our version of Lifo accounting, the price of a commodity is averaged starting with the last purchase of that item e.g., Say we sell 250 shares of a stock, according to this method, the purchase price is determined by averaging the prices on the last 250 shares bought.

In this lab, you will be using a queue for storing data for Fifo accounting, and a stack for  Lifo accounting. 

You should use linked list implementations for your stacks and queue.

Both your stack and queue should have records with the following fields:

The name of the stock (a string or int)
The number of shares of a stock (an int) bought
The purchase price (can be a decimal)
You can assume that the first element of the structure is the stock bought first, the second was bought second, etc.

Your program should have the user able to enter information about various stocks, the amount of shares bought, and the price.  The user can then enter a query about a certain stock and the cost according to the Lifo and Fifo accounting methods for a certain number of shares.

Hint: The following could be your menu:

Press 1 to enter a stock sale
Press 2 to find the Lifo and Fifo price for a stock.

If 1 is pressed, the user needs to enter the stock symbol, the number of shares sold, and the total price.
If 2 is pressed, the user needs to enter the stock symbol being queried and the number of shares in question.