
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        
        int mid = 0;
        int left = 0, right = m - 1; 
        
        while (left <= right) {
            mid = (left + right)/2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        int row = right;
        if (row < 0) return false;
        
        left = 0; right = n-1;
        
        while (left <= right) {
            mid = (left + right)/2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return false;
    }
}
