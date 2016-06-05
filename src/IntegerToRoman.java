
public class IntegerToRoman {
    public String intToRoman(int num) {
        if (num < 0 || num > 3999) return null;
        
        char[] cs = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        
        StringBuffer roman = new StringBuffer();
        
        int scale = 1000;
        
        
        for (int i = 6; i >= 0; i -= 2) {
            int digit = num / scale;
            if (digit != 0) {
                if (digit <= 3) {
                    for (int j = 0; j < digit; j++) {
                        roman.append(cs[i]);         
                    }
                } else if (digit == 4) {
                    roman.append(cs[i]);
                    roman.append(cs[i+1]);
                } else if (digit == 5) {
                    roman.append(cs[i+1]);
                } else if (digit <= 8) {
                    roman.append(cs[i+1]);
                    for (int j=0; j < digit - 5; j++) {
                        roman.append(cs[i]);
                    }
                } else if (digit == 9) {
                    roman.append(cs[i]);
                    roman.append(cs[i+2]);
                }
            }
            
            num = num % scale;
            scale = scale / 10;
        }
        
        return roman.toString();
    }
}
