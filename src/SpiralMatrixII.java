
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n < 0) return null;
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        
        int state = 0;
        int left = -1, right = n, top = 0, bot = n;
        int i = 0, j = 0;
        n = n * n;
        int m = 1;
        
        while (m <= n) {
        switch(state) {
            case 0:
                
                while (j < right) {
                    matrix[i][j] = m++; 
                    j++;
                }
                j--;
                i++;
                right--;
                state = 1;
                break;
            case 1:
                
                while (i < bot) {
                    matrix[i][j] = m++; 
                    i++;
                }
                i--;
                j--;
                bot--;
                state = 2;
                break;
            case 2:
                
                while (j > left) {
                    matrix[i][j] = m++; 
                    j--;
                }
                j++;
                i--;
                left++;
                state = 3;
                break;
            case 3:
                
                while (i > top) {
                    matrix[i][j] = m++; 
                    i--;
                }
                i++;
                j++;
                top++;
                state = 0;
                break;
            default:
                break;
        }
        }
        return matrix;
    }
}
