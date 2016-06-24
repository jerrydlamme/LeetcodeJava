
public class SetMatrixZeros {
	public static void main(String[] args) {
		SetMatrixZeros smz = new SetMatrixZeros();
		int[][] matrix = {{3, 3, 3}, {0, 0, 3}, {3, 3, 3}};
		smz.setZeroes(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(matrix[i][0] + ", " + matrix[i][1] + ", " + matrix[i][2]);
		}
	}
	
	
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row = false, col = false;
        for (int i = 0; i < m; i++) {
        	if (matrix[i][0] == 0) {
        		col = true;
        		break;
        	}
        }

        for (int j = 0; j < n; j++) {
        	if (matrix[0][j] == 0) {
        		row = true;
        		break;
        	}
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (row) {
        	for (int j = 0; j < n; j++) {
        		matrix[0][j] = 0;
        	}
        }
        
        if (col) {
        	for (int j = 0; j < m; j++) {
        		matrix[j][0] = 0;
        	}
        }
    }
}
