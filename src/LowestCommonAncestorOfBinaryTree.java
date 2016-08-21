
public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return root;
        
        TreeNode[] ancestor = new TreeNode[1];
        ancestor[0] = null;
        rec(root, p, q, ancestor);
        return ancestor[0];
    }
    
    int rec(TreeNode node, TreeNode p, TreeNode q, TreeNode[] ancestor) {
        int count = 0;
        if (node == p) count++;
        if (node == q) count++;
        
        if (count == 2) {
            ancestor[0] = node;
            return 2;
        }
        
        if (node.left != null) count += rec(node.left, p, q, ancestor); 
        if (count == 2) {
            if (ancestor[0] == null) ancestor[0] = node;
            return 2;
        }
        
        if (node.right != null) count += rec(node.right, p, q, ancestor); 
        if (count == 2) {
            if (ancestor[0] == null) ancestor[0] = node;
            return 2;
        }
        
        return count;
    }
}
