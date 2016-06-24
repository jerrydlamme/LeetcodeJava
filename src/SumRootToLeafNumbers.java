
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        int[] sum = new int[1];
        sumRec(0, sum, root);
        
        return sum[0];
    }
    
    public void sumRec(int base, int[] sum, TreeNode node) {
        base = base*10 + node.val;
        if (node.left != null) sumRec(base, sum, node.left);
        if (node.right != null) sumRec(base, sum, node.right);
        
        if (node.left == null && node.right == null) sum[0] += base; 
    }
}
