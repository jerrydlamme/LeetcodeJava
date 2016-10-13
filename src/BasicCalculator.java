
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return -1;
        s = s.replaceAll(" +", "");
        s = "(" + s + ")";
        int[] index = new int[1];
        
        return cal(s, index);
    }
    
    int cal(String s, int[] index) {
        int sum = 0;
        
        index[0]++;
        boolean plus = true;
        
        char c = 0;
        while ((c = s.charAt(index[0])) != ')') {
            if (c == '+') {
                plus = true;
                index[0]++;
            } else if (c == '-') {
                plus = false;
                index[0]++;
            } else {
                int next = 0;
                if (c == '(') {
                    next = cal(s, index);
                } else {
                    int start = index[0];
                    int end = start;
                    while (s.charAt(index[0]) >= '0' && s.charAt(index[0]) <= '9') {
                        next *= 10;
                        next += (s.charAt(index[0]) - '0');
                        end++;
                        index[0]++;
                    }
                }
                
                if (plus) {
                    sum += next;
                } else {
                    sum -= next;
                }
                
            }
        }
        index[0]++;
        
        return sum;
    }
}
