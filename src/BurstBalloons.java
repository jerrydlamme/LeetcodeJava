
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            balloons[i] = nums[i-1];
        }
        
        int[][] opt = new int[n+2][n+2];
        
        for (int j = 1; j <= n; j++) {
            for (int i = j; i >= 1; i--) {
                for (int k = i; k <= j; k++) {
                    opt[i][j] = Math.max(opt[i][j], balloons[j+1] * balloons[i-1] * balloons[k] + opt[i][k-1] + opt[k+1][j]);
                }
            }
        }
        
        return opt[1][n];
    }
}
