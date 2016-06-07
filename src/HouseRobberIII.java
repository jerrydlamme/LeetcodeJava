
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        int[] opt = helper(root);
        
        return opt[1];
    }
    
    int[] helper(TreeNode node) {
        if (node == null) return null;
        
        int[] opt = new int[2];
        int[] left, right;
        
        left = helper(node.left);
        right = helper(node.right); 
        
        if (left == null && right == null) {
            opt[1] = node.val;
            opt[0] = 0;
        } else if (left != null && right == null) {
            opt[1] = Math.max(left[0] + node.val, left[1]);
            opt[0] = left[1];
        } else if (left == null && right != null) {
            opt[1] = Math.max(right[0] + node.val, right[1]);
            opt[0] = right[1];
        } else {
            opt[1] = Math.max(left[0] + right[0] + node.val, left[1] + right[1]);
            opt[0] = left[1] + right[1];
        }
        
        return opt;
    }
}
