
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int last = 0, dis = Integer.MAX_VALUE;
        boolean positive = true;
        boolean first = true;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (first) {
                    positive = true;
                    first = false;
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