
public class ValidPerfectSquare {
	public static void main(String[] args) {
		ValidPerfectSquare ob = new ValidPerfectSquare();
		System.out.println(ob.isPerfectSquare(2147483647));
	}
	
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        
        int left = 1, right  = num;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid == num) {
                return true;
            } else if (num / mid >= num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
