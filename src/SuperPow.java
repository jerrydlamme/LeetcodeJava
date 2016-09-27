
public class SuperPow {
    public int superPow(int a, int[] b) {
        int base = a;
        int pro = 1;
        
        for (int i = b.length-1; i >= 0; i--) {
            pro *= pow(base, b[i]);
            base = pow(base, 10);
            if (pro > 1337) pro %= 1337;
        }
        
        return pro % 1337;
    }
    
    int pow(int a, int b) {
        if (b == 0) return 1; 
        if (b == 1) return a % 1337;
        if (a > 1337) a %= 1337;
        if (b == 2) return (a * a) % 1337;
        
        return (((pow(a, b/2) * pow(a, b/2))%1337) * (pow(a, b%2) % 1337))%1337;
    }
}
