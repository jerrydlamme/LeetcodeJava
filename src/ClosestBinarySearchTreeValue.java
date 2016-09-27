
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        long left = Long.MIN_VALUE, right = Long.MAX_VALUE;
        
        TreeNode node = root;
        while (node != null) {
            if (node.val == target) {
                return node.val;
            } else if (node.val < target) {
                left = node.val;
                node = node.right;
            } else {
                right = node.val;
                node = node.left;
            }
        }
        
        return right - target > target - left ? (int)left : (int)right;
    }
}
