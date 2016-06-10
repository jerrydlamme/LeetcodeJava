import java.util.*;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<Integer>();
        int height = matrix.length;
        if (height == 0) return list;
        int width = matrix[0].length;
  
        
        int state = 0;
        int left = -1, right = width, top = 0, bot = height;
        int i = 0, j = 0;
        
        while (true) {
        switch(state) {
            case 0:
                
                while (j < right) {
                    list.add(matrix[i][j]);
                    j++;
                }
                j--;
                i++;
                right--;
                state = 1;
                if (i >= bot) return list;
                break;
            case 1:
                
                while (i < bot) {
                    list.add(matrix[i][j]);
                    i++;
                }
                i--;
                j--;
                bot--;
                state = 2;
                if (j <= left) return list;
                break;
            case 2:
                
                while (j > left) {
                    list.add(matrix[i][j]);
                    j--;
                }
                j++;
                i--;
                left++;
                state = 3;
                if (i <= top) return list;
                break;
            case 3:
                
                while (i > top) {
                    list.add(matrix[i][j]);
                    i--;
                }
                i++;
                j++;
                top++;
                state = 0;
                if (j >= right) return list; 
                break;
            default:
                break;
        }
        }
        
    }
}
