
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        
        while ((a & b) != 0) {
            int x = (a & b) << 1;
            int y = a ^ b;
            
            a = x;
            b = y;
        }
        
        return a | b;
    }
}
