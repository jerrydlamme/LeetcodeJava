
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return (num & (num - 1)) == 0 && num % 3 == 1;
    }
}
