import java.util.*;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0) return false;
        
        for (int i = 1; i < num.length()-1; i++) {
            if (num.charAt(0) == '0' && i == 2) break;
            for (int j = i+1; j < num.length(); j++) {
            	if (num.charAt(i) == '0' && j == i+2) break;
                int start = 0, mid = i, end = j;
                while (end < num.length()) {
                    boolean ok = false;
                    int carry = 0;
                    Stack<Integer> stack = new Stack<Integer>();
                    int x = mid-1, y = end - 1;
                    while (x >= start || y >= mid) {
                        int a = x >= start ? num.charAt(x) - '0' : 0;
                        int b = y >= mid ? num.charAt(y) - '0' : 0;
                        int plus = a + b + carry;
                        stack.push(plus % 10);
                        carry = plus / 10;
                        x--;
                        y--;
                    }
                    if (carry == 1) stack.push(1);
                    int next = end;
                    while (!stack.isEmpty()) {
                        if (next < num.length() && (num.charAt(next) - '0' == stack.pop())) {
                            next++;
                            if (stack.isEmpty()) ok = true;
                        } else {
                            break;
                        }
                    }
                    
                    if (ok) {
                        if (next == num.length()) return true;
                        start = mid; 
                        mid = end;
                        end = next;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	AdditiveNumber ins = new AdditiveNumber();
    	System.out.println(ins.isAdditiveNumber("199100199"));
    }
}
