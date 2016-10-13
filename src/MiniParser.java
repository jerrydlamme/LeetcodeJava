
public class MiniParser {
	/*
    public NestedInteger deserialize(String s) {
        int[] index = new int[1];
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        
        return rec(s, index);
    }
    
    NestedInteger rec(String s, int[] index) {
        NestedInteger ni = new NestedInteger();
        index[0]++;
        while (s.charAt(index[0]) != ']') {
            if (s.charAt(index[0]) == ',') index[0]++;
            if (s.charAt(index[0]) == '[') {
                ni.add(rec(s, index));
                continue;
            } else {
                boolean positive = true;
                if (s.charAt(index[0]) == '-') {
                    positive = false;
                    index[0]++;
                }
                int base = 0;
                while (s.charAt(index[0]) >= '0' && s.charAt(index[0]) <= '9') {
                    base *= 10;
                    base += s.charAt(index[0]++) - '0';
                }
                base = positive ? base : base * (-1);
                ni.add(new NestedInteger(base));
            }
        }
        
        index[0]++;
        return ni;
    }
    */
}