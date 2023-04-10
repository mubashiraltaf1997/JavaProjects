Computing Key Comparisons

Generate a random target between 0 and n-1 and then ask Binary Search to find it. Repeat this 50 times for each array size for each of the Iterative and Recursive Binary search algorithms. Computing the average number of key comparisons. Use a cast so that floating point arithmetic is used to compute the average. Write the array size and the average number of comparisons to the standard output (the comparisons will be the number of times you are "comparing" values in the code i.e., comparing mid point with current index, left with right). The first output lines should be similar to (of course with different values for the number of comparisons, since this is random...you will get different values!!):

n	average number of comparisons
5000	21.64
10000	24.32
15000	25.24
20000	26.08
25000	26.16
30000	27

Paste it into Excel and graph the results.

Next, alter the order of the comparisons in the Binary Search algorithms. Change it so that it performs the test for
array[mid]<target before array[mid]>target...or vice versa if this is not how you've coded it. 

Rearrange the statements that correspond to the comparisons and continue to count the key comparisons correctly. Run the program again and save the output in a file called output2.


For this lab, you need to produce a chart of

n	average number of comparisons
5000	21.64
10000	24.32
15000	25.24
20000	26.08
25000	26.16
30000	27
...	...
100000	32
Put the data into columns in Excel (if you copy from the telnet screen into a word processor, you can replace n blanks with a tab, then copy and paste into Excel will put them into columns). Highlight the columns, click on the Chart Wizard and choose "XY (Scatter)" as the chart type (the icon with lines, not curves). This will use the first column as the X values and plot the rest against each other.

There should be 4 columns of data for each Recursive and Iterative Binary Search, put these in separate Excel Sheets:

The first two as above; a third column like the second one where you have switched the comparisons in BinarySearch. In the fourth column, have Excel enter =2*LOG(A2,2)

What observation can you draw from this?

Hint: You will need arrays of various sizes to solve this problem. Java makes this easy to do. Allocate a new array of size n with the following statement.

int [ ] A = new int[n];


2. Create binary and linear search methods for a user defined object array  of your choosing which can be arranged by some  numerical property. Implement linear and binary search methods to search through an array of these objects that you pre define. Show that your code can search and return the object using intuitive console messages. 