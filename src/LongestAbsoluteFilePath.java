import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        String[] ss = input.split("\n");
        
        int max = 0;
        int len = 0;
        int state = -1;
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            int tabs = s.lastIndexOf('\t') + 1;
            while (state >= tabs) {
                len -= stack.pop();
                state--;
            }
            if (tabs == state+1) {
                stack.push(s.length() - tabs);
                len += s.length() - tabs;
                state++;
            }
            
            if (s.indexOf('.') != -1) {
                max = Math.max(len + state, max);
            }
        }
        
        return max;
    }
}
