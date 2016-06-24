
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        
        int h = 0;
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i-h] > h) h++;
        }
        
        return h;
    }
}
