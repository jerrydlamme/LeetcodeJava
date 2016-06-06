import java.util.*;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                count++;
                if (count == k)
                    return root.val;
                root = root.right;
            }
        }
        
        return 0;
    }
}
