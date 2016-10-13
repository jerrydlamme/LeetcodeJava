import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;
        
        list.add(0);
        
        TreeNode root = new TreeNode(nums[nums.length-1], 1);
        
        for (int i = nums.length-2; i >= 0; i--) {
            list.add(insert(root, nums[i]));
        }
    
        Collections.reverse(list);
    
        return list;
    }
    
    
    int insert(TreeNode root, int val) {
        TreeNode node = root;
        int am = 0;
        
        while (node != null) {
            if (val <= node.val) {
                node.afterMe++;
                if (node.left == null) {
                    node.left = new TreeNode(val, 1);
                    return am;
                } else {
                    node = node.left;
                    continue;
                }
            } else {
                am += node.afterMe;
                if (node.right == null) {
                    node.right = new TreeNode(val, 1);
                    return am;
                } else {
                    node = node.right;
                    continue;
                }
            }
        }
        
        return am;
    }
}