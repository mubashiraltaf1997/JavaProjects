import java.util.Stack;

public class DataStructures {
    public static void main(String[] args) {
        System.out.println("------------------------1------------------------");
        // Create a linked list of integers
        ListNode head = new ListNode("3");
        ListNode node1 = new ListNode("4");
        ListNode node2 = new ListNode("5");
        ListNode node3 = new ListNode("29");
        ListNode node4 = new ListNode("45");
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // Print the original linked list
        System.out.println("Original linked list:");
        printLinkedList(head);

        // Convert integers to words
        LinkedListConverter converter = new LinkedListConverter();
        ListNode convertedHead = converter.numberToWords(head);

        // Print the converted linked list
        System.out.println("Linked list after converting integers to words:");
        printLinkedList(convertedHead);


        System.out.println("\n------------------------2------------------------");
        // Create the first stack and push strings "A" to "Z"
        Stack<String> stack1 = new Stack<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            stack1.push(String.valueOf(c));
        }

        // Create the second stack
        Stack<String> stack2 = new Stack<>();

        // Pop strings from stack1 and push onto stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Pop strings from stack2 and print
        System.out.println("Strings printed from stack2:");
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
        System.out.println("\nAs you can see that string are printed in the same alphabetical order from A-Z");


        System.out.println("\n------------------------5------------------------");
        // Create a sample BST
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Create an instance of BSTProductCalculator
        BSTProductCalculator calculator = new BSTProductCalculator();

        // Compute the product of all nodes in the BST
        int product = calculator.getProductOfAllNodes(root);

        System.out.println("Product of all nodes in the BST: " + product);
    }

    // Utility method to print the linked list
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}