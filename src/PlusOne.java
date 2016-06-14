
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        
        int carry = 0;
        digits[digits.length-1] += 1;
        
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        
        if (carry == 1) {
            int[] update = new int[digits.length+1];
            update[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                update[i+1] = digits[i];
            }
            
            return update;
        } 
        
        return digits;
    }
}
