import java.util.*;
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode lastNode = null;
        
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek();
                if (root.right != null && lastNode != root.right) {
                    root = root.right;
                } else {
                    list.add(root.val);
                    lastNode = stack.pop();
                    root = null;
                }
            }
        }
        
        return list;
    }
}
