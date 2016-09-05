
public class CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        
        sub(root);
        return count;
    }
    
    boolean sub(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean ret = true;
        
        if (node.left != null) ret = sub(node.left);
        if (node.right != null) ret = sub(node.right) && ret;
        
        if (!ret) return false;
        
        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;
        
        count++;
        return true;
    }
}
