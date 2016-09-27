
public class LongestIncreasingPathInMatrix {
    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mask = new int[m][n];
                
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (smallest(i, j, matrix)) {
                    dfs(matrix, mask, i, j, 1);
                }
            }
        }
        
        return max;
    }
    
    void dfs(int[][] matrix, int[][] mask, int i, int j, int value) {
        if (mask[i][j] >= value) return;
        
        mask[i][j] = value;
        max = value > max ? value : max;
        value++;
        if (i-1 >= 0 && matrix[i-1][j] > matrix[i][j] && mask[i-1][j] < value) dfs(matrix, mask, i-1, j, value);
        if (j-1 >= 0 && matrix[i][j-1] > matrix[i][j] && mask[i][j-1] < value) dfs(matrix, mask, i, j-1, value);
        if (i+1 < matrix.length && matrix[i+1][j] > matrix[i][j] && mask[i+1][j] < value) dfs(matrix, mask, i+1, j, value);
        if (j+1 < matrix[0].length && matrix[i][j+1] > matrix[i][j] && mask[i][j+1] < value) dfs(matrix, mask, i, j+1, value);
    }
    
    boolean smallest (int i, int j, int[][] matrix) {
        if (i-1 >= 0 && matrix[i-1][j] < matrix[i][j]) return false;
        if (j-1 >= 0 && matrix[i][j-1] < matrix[i][j]) return false;
        if (i+1 < matrix.length && matrix[i+1][j] < matrix[i][j]) return false;
        if (j+1 < matrix[0].length && matrix[i][j+1] < matrix[i][j]) return false;
        
        return true;
    }
}
