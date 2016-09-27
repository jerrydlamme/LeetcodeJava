import java.util.Stack;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        boolean ready = false;
        
        
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (ready) return node;
                if (node.val == p.val) ready = true;
                node = node.right;
            }
        }
        
        return null;
    }
}
