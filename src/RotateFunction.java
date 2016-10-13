
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int max = 0;
        int start = 0;
        int base = 0;
        
        for (int i = 0; i < A.length; i++) {
            base += A[i];
            start += A[i] * i;
        }
        max = start;
        
        for (int i = A.length - 1; i > 0; i--) {
            start += base - A[i] * A.length;
            max = Math.max(max, start);
        }
        
        return max;
    }
}
