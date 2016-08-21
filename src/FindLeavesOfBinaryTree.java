import java.util.*;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (root == null) return lists;
        
        find(root, lists);
    
        return lists;
    }
    
    int find(TreeNode node, List<List<Integer>> lists) {
        int level = 0;
        int left_level = 0;
        int right_level = 0;
        if (node.left == null && node.right == null) {
            level =0;
        } else {
            if (node.left != null) left_level = find(node.left, lists);
            if (node.right != null) right_level = find(node.right, lists);
            level = Math.max(left_level, right_level) + 1;
        }
        
        if (lists.size() > level) {
            lists.get(level).add(node.val);
        } else {
            List<Integer> list = new LinkedList<Integer>();
            list.add(node.val);
            lists.add(list);
        }
        
        return level;
    }
}
