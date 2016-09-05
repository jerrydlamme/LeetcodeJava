
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0; 
        
        int[] row = new int[grid[0].length];
        int[] col = new int[grid.length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length;j++) {
                if (grid[i][j] == 1) {
                    row[j]++;
                    col[i]++;
                }
            }
        }
        
        return sum(col) + sum(row);
    }
    
    int sum(int col[]) {
        int x = 0;
        int sum = 0;
        for (int i = 0; i < col.length; i++) {
            sum += col[i];
        }
        if (sum%2 == 0) {
            sum /= 2;
        } else {
            sum = sum/2 + 1;
        }

        int mid_x = 0;
        for (; sum >0; mid_x++) {
            sum -= col[mid_x];
        }
        mid_x--;
        
        for (int i = 0; i < col.length; i++) {
            x += Math.abs(i - mid_x) * col[i];
        }
        
        return x;
    }
}
