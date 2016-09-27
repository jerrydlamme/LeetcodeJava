
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return false;

        int i = 0;
        while (i < data.length) {
            int a = data[i] & 0xFF;
            int count = 0;

            if (a <= 127) {
                i++;
                continue;
            } else if (a >= 192 && a <= 223) {
                count = 1;
            } else if (a >= 224 && a <= 239) {
                count = 2;
            } else if (a >= 240 && a <= 247) {
                count = 3;
            } else {
                return false;
            }
            i++;
            
            for (int j = 0; j < count; j++) {
                if (i >= data.length) return false;
                a = data[i] & 0xFF;
                if (a < 128 || a > 128 + 63) return false;
                i++;
            }
        }
        
        return true;
    }
}
