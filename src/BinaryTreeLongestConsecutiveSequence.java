
public class BinaryTreeLongestConsecutiveSequence {
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        rec(root);
        
        return max;
    }
    
    int rec(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
        	System.out.println("leaf = " + root.val);
        	return 1;
        }
        
        int left = 1, right = 1;
        
        if (root.left != null) {
            left = longestConsecutive(root.left);
//            System.out.println("left = " + left);
            if (root.val + 1 == root.left.val) {
                left++;
            } else {
                left = 1;
            }
        }
        
        if (root.right != null) {
            right = longestConsecutive(root.right);
           System.out.println("node = " + root.val + ", " + "right = " + right);
            if (root.val + 1 == root.right.val) {
                right++;
            } else {
                right = 1;
            }
        }
        
        int len = Math.max(left, right);
        
        max = Math.max(max, len);
            System.out.println("node = " + root.val + ", " + "ret = " + len);
        
        return len;
    }
    
    public static void main(String[] args) {
    	BinaryTreeLongestConsecutiveSequence ob = new BinaryTreeLongestConsecutiveSequence();
    	
    	TreeNode root = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node5 = new TreeNode(5);
    	
    	root.right = node3;
    	node3.left = node2;
    	node3.right = node4;
    	node4.right = node5;

    	int i = ob.longestConsecutive(root);
    	System.out.println(i);
    }
}
