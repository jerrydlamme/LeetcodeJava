
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        for (int i = 0; i < 32; i++) {
            if ((m >> i) == (n >> i)) {
                return ((m >> i) << i);
            }
        }
        
        return 0;
    }
}
