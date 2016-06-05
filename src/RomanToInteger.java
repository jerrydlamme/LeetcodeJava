
public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null) return 0;
        
        char[] arr = s.toCharArray();
        
        int ret = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && c2n(arr[i]) > c2n(arr[i-1])) {
                ret += c2n(arr[i]) - 2 * c2n(arr[i-1]);
            } else {
                ret += c2n(arr[i]);
            }
        }
        
        return ret;
    }
    
    public int c2n(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
