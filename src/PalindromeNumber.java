
public class PalindromeNumber {

   	public static void main(String[] args) {
   		PalindromeNumber pn = new PalindromeNumber();
   		System.out.println(pn.isPalindrome(1001));
   	}

    public boolean isPalindrome(int x) {
    	
        if (x < 0) return false;
        
        int div = 1;
        while (x/div >= 10) {
            div *= 10;
        }
        System.out.println(div);
        
        while (x > 0) {
            int left = x/div;
            int right = x%10;
            if (left != right) return false;
            x -= left*div;
            div /= 100;
            x /= 10;
        }
        
        return true;
    }
}
