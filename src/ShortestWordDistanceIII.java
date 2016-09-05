
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int last = 0, dis = Integer.MAX_VALUE;
        boolean positive = true;
        boolean first = true;
        boolean same = false;
        if (word1.equals(word2)) same = true;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (first) {
                    positive = true;
                    first = false;
                    if (same) {
                        last = i;
                        continue;
                    }
                }
                
                if (same) {
                    dis = Math.min(dis, i-last);
                    last = i;
                    continue;
                }
                
                if (positive) {
                    last = i;
                } else {
                    dis = Math.min(dis, i-last);
                    positive = !positive;
                    last = i;
                }
            } else if (words[i].equals(word2)) {
                if (first) {
                    positive = false;
                    first = false;
                }
                if (!positive) {
                    last = i;
                } else {
                    dis = Math.min(dis, i-last);
                    positive = !positive;
                    last = i;
                }
            }
        }
        
        return dis;
    }
}
