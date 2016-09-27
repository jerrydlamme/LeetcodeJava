import java.util.*;

public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new LinkedList<Integer>();
        
        TreeNode left = null, right = null;
        TreeNode mid = null;
        TreeNode start = root;
        while (start != null) {
            if (start.val == target) {
                mid = start;
                list.add(start.val);
                break;
            } else if (start.val < target) {
                left = start;
                start = start.right;
            } else {
                right = start;
                start = start.left;
            }
        }
        
        if (mid != null) {
            System.out.println(mid.val);
            left = predecessor(root, mid);
            right = successor(root, mid);
        }
        
        while (list.size() < k) {
            if (left == null) {
                list.add(right.val);
                right = successor(root, right);
                continue;
            }
            
            if (right == null) {
                list.add(left.val);
                left = predecessor(root, left);
                continue;
            }
        
            if (target - left.val > right.val - target) {
                list.add(right.val);
                right = successor(root, right);
            } else {
                list.add(left.val);
                left = predecessor(root, left);
            }
        }
        
        return list;
    }
    
    TreeNode successor(TreeNode root, TreeNode p) {
        while (root != null && root.val <= p.val) {
            root = root.right;
        }
        if (root == null) return null;
        TreeNode left = successor(root.left, p);
        return left == null? root : left;
    }
    
    TreeNode predecessor(TreeNode root, TreeNode p) {
        while (root != null && root.val >= p.val) {
            root = root.left;
        }
        if (root == null) return null;
        TreeNode right = predecessor(root.right, p);
        return right == null? root : right;
    }
}
