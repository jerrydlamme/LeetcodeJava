
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] uglys = new int[n];
        uglys[0] = 1;
        
        int ind2 = 0, ind3 = 0, ind5 = 0;
        
        int i = 1;
        
        while (i < n) {
            int u2 = uglys[ind2]*2, u3 = uglys[ind3]*3, u5 = uglys[ind5]*5;
            int next = Math.min(u2, Math.min(u3, u5));
            
            if (next == u2) {
                ind2++;
            } else if (next == u3) {
                ind3++;
            } else {
                ind5++;
            }
            
            if (next != uglys[i-1]) {
                uglys[i] = next;
                i++;
            }
        }
        
        return uglys[n-1];
    }
}
