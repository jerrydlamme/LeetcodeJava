
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null) return 0;
        s  = s.replaceAll(" +", "");
        char sign = '+';
        
        int i = 0;
        long pre = 0;
        int res = 0;
        while (i < s.length()) {
            long cur = 0;
            
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                cur *= 10;
                cur += s.charAt(i) - '0';
                i++;
            }
            
            if (sign == '+') {
                res += pre;
                pre = cur;
            } else if (sign == '-') {
                res += pre;
                pre = -cur;
            } else if (sign == '*') {
                pre *= cur;
            } else {
                pre /= cur;
            }
            
            if (i < s.length())
                sign = s.charAt(i++);
        }
        
        res += pre;
        
        return res;
    }
}


