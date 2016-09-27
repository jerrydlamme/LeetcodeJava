
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int houses = costs.length;
        int colors = costs[0].length;
        int[][] opt = new int[houses][colors];
        
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for (int i = 0; i < colors; i++) {
            opt[0][i] = costs[0][i];
            
            if (opt[0][i] <= min1) {
                min2 = min1;
                min1 = opt[0][i];
            } else if (opt[0][i] < min2) {
                min2 = opt[0][i];
            }
        }
        
        for (int i = 1; i < houses; i++) {
            int nextMin1 = Integer.MAX_VALUE;
            int nextMin2 = Integer.MAX_VALUE;
            for (int j = 0; j < colors; j++) {
                opt[i][j] = costs[i][j] + (min1 == opt[i-1][j] ? min2 : min1);
                if (opt[i][j] <= nextMin1) {
                    nextMin2 = nextMin1;
                    nextMin1 = opt[i][j];
                } else if (opt[i][j] < nextMin2) {
                    nextMin2 = opt[i][j];
                }
            }
            min1 = nextMin1;
            min2 = nextMin2;
        }
        
        return min1;
    }
}
