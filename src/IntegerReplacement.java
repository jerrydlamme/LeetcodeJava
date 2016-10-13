
public class IntegerReplacement {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        
        int count = 0;
        
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                count++;
            } else {
                if (n == 3) {
                    n--;
                    count++;
                } else if ((n-1) % 4 == 0) {
                    n = (n-1) / 4;
                    count += 3;
                } else {
                    n = n/2 + 1;
                    count += 2;
                }
            }
        }
        return count;
    }
}
