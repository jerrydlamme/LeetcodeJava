
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        
        int min = Math.min(s.length(), t.length());
        
        for (int i = 0; i < min; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i+1));
                } else {
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        
        return Math.abs(s.length() - t.length()) == 1;
    }
}
