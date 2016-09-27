
public class FindCelebrity {
    public int findCelebrity(int n) {
        int rem = 0;
        int last = -1;
        for (int i = 1; i < n; i++) {
            if (knows(rem, i)) {
                last = rem;
                rem = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i == last || i == rem) continue;
            if (!knows(i, rem)) return -1;
        }
        
        for (int i = 0; i < rem; i++) {
            if (knows(rem, i)) return -1;
        }
        
        return rem;
    }
    
    boolean knows(int a, int b) {
    	return false;
    }
}
