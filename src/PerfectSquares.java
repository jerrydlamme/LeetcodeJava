
public class PerfectSquares {
	
	public static void main(String[] args) {
		PerfectSquares ps = new PerfectSquares();
		ps.numSquares(5);
	}
	
    public int numSquares(int n) {
        if (n < 0) return -1;
        
        int[] opt = new int[n+1];
        opt[0] = 1;
        opt[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int sqt  = (int) Math.sqrt(i);
            if (sqt * sqt == i) {
                opt[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1, k = i-1; j <=k; j++, k--) {
                    min = Math.min(min, opt[j] + opt[k]);
                }
                opt[i] = min;
            }
        }

        for (int i = 0; i <= n; i++) {
        	System.out.println(opt[i]);
        }
        
        return opt[n];
    }
}
