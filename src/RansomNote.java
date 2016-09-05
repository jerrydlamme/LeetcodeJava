
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] mask = new int[26];
        
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            mask[c - 'a']++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (--mask[c - 'a'] < 0) return false;
        }
        
        return true;
    }
}
