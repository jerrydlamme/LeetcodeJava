
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int i = -1;
        
        for (int val : preorder) {
            if (val < low) return false;
            
            while (i >= 0 && preorder[i] < val) {
                low = preorder[i--];
            }
            
            preorder[++i] = val;
        }
        
        return true;
    }
}
