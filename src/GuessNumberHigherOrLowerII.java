
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] opt = new int[n+1][n+1];
        
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i >= 1; i--) {
                opt[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if (k == i) {
                        opt[i][j] = Math.min(opt[i][j], k + opt[k+1][j]);
                    } else if (k == j) {
                        opt[i][j] = Math.min(opt[i][j], k + opt[i][k-1]);
                    } else {
                        opt[i][j] = Math.min(opt[i][j], k + Math.max(opt[i][k-1], opt[k+1][j]));
                    }
                    
                }
            }
        }
        
        return opt[1][n];
    }
}
