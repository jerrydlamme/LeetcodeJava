import java.util.*;
public class HappyNumbers {
    public boolean isHappy(int n) {
        int digit;
        Set<Integer> set = new HashSet<Integer>();
        
        while (n != 1) {
            int sum = 0;
            int tmp = n;
            while (tmp > 0) {
                digit = tmp % 10;
                sum += digit * digit;
                tmp /= 10;
            }
            n = sum;
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        
        return true;
    }
}
