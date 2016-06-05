
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int n = words.length;
        int max = 0;
        int[] mask = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
            
            for (int j = 0; j < i; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = words[i].length() * words[j].length() > max ? words[i].length() * words[j].length() : max;
                }
            }
        }
        
        return max;
    }
}
