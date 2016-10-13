
public class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int area = bfs(matrix, i, j);
                    max = area > max ? area : max;
                }
            }
        }
        
        return max;
    }
    
    int bfs(char[][] matrix, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        int level = 0;
        while (i + level < m && j + level < n) {
            for (int a = i; a <= i + level; a++) {
                if (matrix[a][j+level] == '0') return level * level; 
            }
            for (int b = j; b <= j + level; b++) {
                if (matrix[i+level][b] == '0') return level * level; 
            }
            level++;
        }
        
        return level * level;
    }
}