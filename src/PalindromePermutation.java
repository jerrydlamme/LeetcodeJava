
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] cs = new int[256];
        boolean once = false;
        
        
        for (int i = 0; i < s.length(); i++) {
            cs[s.charAt(i)]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (cs[i] % 2 == 1) {
                if (!once) {
                    once = !once;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
