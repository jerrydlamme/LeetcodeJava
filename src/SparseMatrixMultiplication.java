
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null) return null;
        int row = A.length;
        
        if (row == 0) return new int[0][0];
        
        int col = B[0].length;
        int[][] pro = new int[row][col];
        int mul = A[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < mul; k++) {
                    if (A[i][k] != 0) {
                        pro[i][j] += A[i][k] * B[k][j];
                    }
                    
                }
            }
        }
        
        return pro;
    }
}
