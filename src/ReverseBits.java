
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int bit;
        int rev = 0;
        for (int i = 31; i >= 0; i--) {
            bit = (n & 1);
            n >>= 1;
            rev |= (bit << i);
        }
        
        return rev;
    }
}
