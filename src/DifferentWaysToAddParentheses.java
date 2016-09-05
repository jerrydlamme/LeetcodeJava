import java.util.*;

public class DifferentWaysToAddParentheses {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new LinkedList<Integer>();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                
                List<Integer> lefts = null, rights = null;
                
                if (map.containsKey(part1)) {
                    lefts = map.get(part1);
                } else {
                    lefts = diffWaysToCompute(part1);
                    map.put(part1, lefts);
                }
                
                if (map.containsKey(part2)) {
                    rights = map.get(part2);
                } else {
                    rights = diffWaysToCompute(part2);
                    map.put(part2, rights);
                }

                for (Integer left : lefts) {
                    for (Integer right : rights) {
                        if (c == '+') {
                            list.add(left + right);
                        } else if (c == '-') {
                            list.add(left - right);
                        } else {
                            list.add(left * right);
                        }
                    }
                }
            }
        }
        
        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        } 
        
        return list;
    }
}
