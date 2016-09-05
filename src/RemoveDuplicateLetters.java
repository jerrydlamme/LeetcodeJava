import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) return s;
        Stack<Character> stack = new Stack<Character>();
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        for (int i = 0; i < str.length; i++) {
            counts[str[i] - 'a']++;
        }
        
        boolean[] visited = new boolean[26];
        
        StringBuffer buffer = new StringBuffer();
 
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            int index = c - 'a';
            
            if (visited[index]) {
                counts[index]--;
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek() > c && counts[stack.peek() - 'a'] > 1) {
                counts[stack.peek()-'a']--;
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            
            stack.push(c);
            visited[index] = true;
        }
        
        for (Character ch : stack) {
            buffer.append(ch);
        }
 
        return buffer.toString();
    }
}
