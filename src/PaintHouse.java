
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int length = costs.length;
        int[][] opt = new int[length][3];
        
        opt[0][0] = costs[0][0];
        opt[0][1] = costs[0][1];
        opt[0][2] = costs[0][2];
        
        for (int i = 1; i < length; i++) {
            opt[i][0] = Math.min(opt[i-1][1], opt[i-1][2]) + costs[i][0];
            opt[i][1] = Math.min(opt[i-1][0], opt[i-1][2]) + costs[i][1];
            opt[i][2] = Math.min(opt[i-1][0], opt[i-1][1]) + costs[i][2];
        }
        
        return Math.min(Math.min(opt[length-1][0], opt[length-1][1]), opt[length-1][2]);
    }
}
