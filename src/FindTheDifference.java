
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += t.charAt(i) - s.charAt(i);
        }
        
        res += t.charAt(t.length()-1);
        
        return (char)res;
    }
}
