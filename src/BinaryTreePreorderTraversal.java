import java.util.*;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        
        if (root == null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                list.add(root.val);
                if (root.right != null) stack.add(root.right);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        
        return list;
    }
}
