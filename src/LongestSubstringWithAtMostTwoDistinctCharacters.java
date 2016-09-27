
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int k = 2;
        
        if (k == 0) return 0;
        int left = 0, right = 0;
        int dis = 0;
        int[] map = new int[256];
        int max = 0;
        
        while (right < s.length()) {
            if (dis < k || map[s.charAt(right)] > 0) {
                max = Math.max(max, right - left + 1);
                if (map[s.charAt(right)]== 0) {
                    dis++;
                }
                map[s.charAt(right)]++;
                right++;
            } else {
                while (--map[s.charAt(left)] > 0) {
                    left++;
                }
                left++;
                dis--;
            }
        }
        
        return  max;
    }
}
