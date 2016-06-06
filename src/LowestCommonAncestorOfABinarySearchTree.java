
public class LowestCommonAncestorOfABinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        
        while (root != null) {
            if (q.val < root.val && p.val < root.val) {
                root = root.left;
            } else if (q.val > root.val && p.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        
        return null;
    }
}
