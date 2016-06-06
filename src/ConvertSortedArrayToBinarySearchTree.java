
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return helper(nums, 0, nums.length-1);
    }
    
    TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[(left + right) / 2]);
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid+1, right);
        return root;
    }
}
