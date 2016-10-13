public class LargestBSTSubtree {
    int max = 1;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        sub(root);
        return max;
    }
    
    int[] sub(TreeNode node) {
        int[] ret = new int[3];
        int[] left = null;
        int[] right = null;
        
        if (node.left == null && node.right == null) {
            ret[0] = 1;
            ret[1] = node.val;
            ret[2] = node.val;
            return ret;
        }
        
        if (node.left != null) left = sub(node.left);
        if (node.right != null) right = sub(node.right);

        if((left != null && left[0] == -1) || (right != null && right[0] == -1)) {
            ret[0] = -1;
            return ret;
        }
        
        if (left != null) {
            if (left[2] > node.val) {
                ret[0] = -1;
                return ret;
            } else {
                ret[1] = left[1];
                ret[0] += left[0];
            }
        } else {
            ret[1] = node.val;
        }
        
        if (right != null) {
            if (right[1] < node.val) {
                ret[0] = -1;
                return ret;
            } else {
                ret[2] = right[2];
                ret[0] += right[0];
            }
        } else {
            ret[2] = node.val;
        }
        
        ret[0]++;
        max = Math.max(max, ret[0]);

        return ret;
    }
}