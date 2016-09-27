
public class GuessNumberHighterOrLower {
    public int guessNumber(int n) {
        int left = 1, right = n, mid = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            } 
        }
        
        return mid;
    }
    
    int guess(int i) {
    	return 0;
    }
}
