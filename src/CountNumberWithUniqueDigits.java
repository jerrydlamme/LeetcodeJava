
public class CountNumberWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        if (n == 2) return 91;
        int[] opt = new int[Math.min(n, 10)+1];
        opt[1] = 10; 
        opt[2] = 91;
        for (int i = 3; i <= n && i <= 10; i++) {
            opt[i] = (opt[i-1] - opt[i-2])* (10 - i + 1) + opt[i-1];
        }
        
        return n < 10 ? opt[n] : opt[10];
    }
}
