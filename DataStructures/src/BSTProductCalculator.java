import java.util.Stack;

public class BSTProductCalculator {
    public int getProductOfAllNodes(TreeNode root) {
        if (root == null) {
            return 1; // Base case: empty node has a product of 1
        }

        int product = 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            product *= curr.val; // Multiply current node's value with product
            curr = curr.right;
        }

        return product;
    }
}