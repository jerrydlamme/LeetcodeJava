public class NimGame {
    public boolean canWinNim(int n) {
        return n <= 0 ? false : (n % 4 != 0);
    }
}