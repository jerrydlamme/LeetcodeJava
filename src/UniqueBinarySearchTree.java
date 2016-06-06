
public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        
        if (n == 0) return 0;
        
        int[] counts = new int[n+1];
        counts[1] = 1;
        counts[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                counts[i] += counts[j-1] * counts[i-j];
            }
        }
        
        return counts[n];
    }
}
