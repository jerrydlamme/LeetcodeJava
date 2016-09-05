
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length()-1; i <= j; i++, j--) {
            char left = num.charAt(i);
            char right = num.charAt(j);
            
            if (left != right) {
                if (!((left == '6'&& right == '9') || (left == '9' && right == '6'))) return false;
            } else {
                if (left != '0' && left != '1' && left != '8') return false;
            }
        }
        
        return true;
    }
}
