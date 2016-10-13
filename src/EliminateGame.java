import java.util.*;

public class EliminateGame {
    public int lastRemaining(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int i = n;
        int count = 0;
        while (i > 1) {
            stack.push(i);
            i = (i/2);
            count++;
            System.out.println("i = " + i + " count= " + count);
        }
        
        int ret = 1;
        int cur = 1;
        while (count > 0) {
            int next = stack.pop();
            if (count % 2 == 0) {
                int offset = (cur - ret) * 2 + 1;
                ret = next - offset;
                cur = next;
            } else {
                cur = next;
                ret += ret;
            }
            System.out.println(ret);
            count--;
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
    	EliminateGame ins = new EliminateGame();	 	
    	System.out.println("ret: " + ins.lastRemaining(9));
    }
}
