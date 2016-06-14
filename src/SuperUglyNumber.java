
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        
        int[] uglys = new int[n];
        uglys[0] = 1;
        
        int i = 1;
        
        while (i < n) {
            int min_index = 0, next = Integer.MAX_VALUE;
            
            for (int j = 0; j < index.length; j++) {
                int pro = primes[j] * uglys[index[j]];
                if (pro < next) {
                    next = pro;
                    min_index = j;
                }
            }
            
            index[min_index]++;
            
            if (next != uglys[i-1]) {
                uglys[i] = next;
                i++;
            }
        }
        
        return uglys[n-1];
    }
}
